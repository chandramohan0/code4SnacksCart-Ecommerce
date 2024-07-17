package com.chandraMohan.code4SnacksCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandraMohan.code4SnacksCart.entity.ItemDetails;
import com.chandraMohan.code4SnacksCart.service.ItemDetailService;

@RestController
@RequestMapping("/details")
public class ItemDetailController {

	@Autowired
	ItemDetailService itemDetailService;
	
	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable int id) {
		itemDetailService.delete(id);
	}
	
	@GetMapping("/item/price/{price}")
	public List<ItemDetails> getItemDetailsForPrice(@PathVariable double price){
		return itemDetailService.getItemDetailsForPrice(price);
	}
	
	@GetMapping("/item/category/{category}")
	public List<ItemDetails> getItemDetailsForCategory(@PathVariable String category){
		return itemDetailService.getItemDetailsForCategory(category);
	}
}
