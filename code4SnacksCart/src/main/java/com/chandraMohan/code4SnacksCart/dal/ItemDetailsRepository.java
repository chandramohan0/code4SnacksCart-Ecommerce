package com.chandraMohan.code4SnacksCart.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chandraMohan.code4SnacksCart.entity.ItemDetails;

public interface ItemDetailsRepository extends JpaRepository<ItemDetails, Integer>{
	
	//Derived Query
	List<ItemDetails> findByPriceGreaterThan(double price);
	
//	//JPQL
//	@Query("SELECT itd from ItemDetails itd where itd.category=?1 ORDER BY itd.price DESC")
//	List<ItemDetails> findByCategoryOrderByPrice(String category);
	
	//Alternate for "JPQL" is "NamedQuery" at Entity Level
	List<ItemDetails> findByCategoryOrderByPrice(String category);
}
