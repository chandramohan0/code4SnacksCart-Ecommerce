package com.chandraMohan.code4SnacksCart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandraMohan.code4SnacksCart.entity.ItemReview;
import com.chandraMohan.code4SnacksCart.service.ItemReviewService;

@RestController
@RequestMapping("/review")
public class ItemReviewController {
	
	@Autowired
	ItemReviewService itemReviewService;
	
	@PostMapping("/save")
	public void save(@RequestBody ItemReview review) {
		itemReviewService.save(review);
	}
}
