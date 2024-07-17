package com.chandraMohan.code4SnacksCart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandraMohan.code4SnacksCart.dal.ItemRepository;
import com.chandraMohan.code4SnacksCart.entity.Item;
import com.chandraMohan.code4SnacksCart.entity.ItemReview;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public Item getItemById(int id) {
		// TODO Auto-generated method stub
		return itemRepository.findById(id).get();
	}

	public void saveItem(Item item) {
		// TODO Auto-generated method stub
		if (item.getItemReview() != null) {
			 for (ItemReview review : item.getItemReview()) {
	                review.setItem(item);
	         }
	    }
		itemRepository.save(item);
	}

	public void deleteItem(int id) {
		// TODO Auto-generated method stub
		itemRepository.deleteById(id);
	}

	public void updateItem(Item updateItem) {
		// TODO Auto-generated method stub
		if (updateItem.getItemReview() != null) {
            for (ItemReview review : updateItem.getItemReview()) {
                review.setItem(updateItem);
            }
        }
		itemRepository.save(updateItem);
	}

	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		List<Item> itemList = new ArrayList<>();
		itemRepository.findAll().forEach(item -> itemList.add(item));
		return itemList;
	}

	public List<Item> getItemByDesc(String desc) {
		// TODO Auto-generated method stub
		return itemRepository.getItemByDesc(desc);
	}
	
}
