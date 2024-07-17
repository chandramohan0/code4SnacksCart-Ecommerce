package com.chandraMohan.code4SnacksCart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandraMohan.code4SnacksCart.dal.ItemReviewRepository;
import com.chandraMohan.code4SnacksCart.entity.ItemReview;

@Service
public class ItemReviewService {

	@Autowired
	ItemReviewRepository itemReviewRepository;
	
	public void save(ItemReview review) {
		// TODO Auto-generated method stub
		itemReviewRepository.save(review);
	}

}
