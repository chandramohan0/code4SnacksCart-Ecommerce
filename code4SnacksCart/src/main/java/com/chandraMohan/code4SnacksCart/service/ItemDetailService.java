package com.chandraMohan.code4SnacksCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandraMohan.code4SnacksCart.dal.ItemDetailsRepository;
import com.chandraMohan.code4SnacksCart.entity.ItemDetails;

@Service
public class ItemDetailService {

	@Autowired
	ItemDetailsRepository itemDetailsRepository;
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		itemDetailsRepository.deleteById(id);
	}

	public List<ItemDetails> getItemDetailsForPrice(double price) {
		// TODO Auto-generated method stub
		return itemDetailsRepository.findByPriceGreaterThan(price);
	}

	public List<ItemDetails> getItemDetailsForCategory(String category) {
		// TODO Auto-generated method stub
		return itemDetailsRepository.findByCategoryOrderByPrice(category);
	}
	
	
}
