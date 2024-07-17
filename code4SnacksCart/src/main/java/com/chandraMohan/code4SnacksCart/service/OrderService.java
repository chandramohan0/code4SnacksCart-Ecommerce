package com.chandraMohan.code4SnacksCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandraMohan.code4SnacksCart.dal.ItemRepository;
import com.chandraMohan.code4SnacksCart.dal.OrderRepository;
import com.chandraMohan.code4SnacksCart.entity.Item;
import com.chandraMohan.code4SnacksCart.entity.Order;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id).get();
	}

	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		List<Item> itemList = order.getItems();
        for (Item item : itemList) {
            if (itemRepository.existsById(item.getId())) {
                itemList.set(itemList.indexOf(item), itemRepository.findById(item.getId()).get());
            }
        }
        order.setItems(itemList);
        orderRepository.save(order);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(id);
	}

}
