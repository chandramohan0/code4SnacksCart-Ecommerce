package com.chandraMohan.code4SnacksCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandraMohan.code4SnacksCart.entity.Item;
import com.chandraMohan.code4SnacksCart.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
	
	@GetMapping("/id/{id}")
	public Item getItemById(@PathVariable int id) {
		return itemService.getItemById(id);
	}
	
	@PostMapping("/save")
	public void saveItem(@RequestBody Item item) {
		itemService.saveItem(item);
	}
	
	@DeleteMapping("/delete/id/{id}")
	public void deleteItem(@PathVariable int id) {
		itemService.deleteItem(id);
	}
	
	@PutMapping("/update")
	public void updateItem(@RequestBody Item updateItem) {
		itemService.updateItem(updateItem);
	}
	
	@GetMapping("/desc/{desc}")
	public List<Item> getItemByDesc(@PathVariable String desc) {
		return itemService.getItemByDesc(desc);
	}
}
