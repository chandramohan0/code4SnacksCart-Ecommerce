package com.chandraMohan.code4SnacksCart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandraMohan.code4SnacksCart.entity.Order;
import com.chandraMohan.code4SnacksCart.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("/id/{id}")
	public Order getOrderById(@PathVariable int id) {
		return orderService.getOrderById(id);
	}
	
	@PostMapping("/save")
	public void saveOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
	}
	
	@DeleteMapping("/delete/id/{id}")
	public String deleteOrder(@PathVariable int id) {
		orderService.delete(id);
		return "Order has been deleted with id: " + id;
	}
	
}
