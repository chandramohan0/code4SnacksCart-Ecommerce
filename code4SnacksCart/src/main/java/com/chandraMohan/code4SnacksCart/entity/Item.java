package com.chandraMohan.code4SnacksCart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@NamedNativeQuery(name = "Item.getItemByDesc", query = "SELECT * FROM  item WHERE description LIKE CONCAT(?1, '%') LIMIT 4", resultClass = Item.class)
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String description;
	  
	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private ItemDetails itemDetails;
	
	@OneToMany(mappedBy="item", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ItemReview> itemReview;
	
	@ManyToMany(mappedBy = "items")
	@JsonIgnore
	private List<Order> orders;
	
	public List<ItemReview> getItemReview() {
		return itemReview;
	}
	public void setItemReview(List<ItemReview> itemReview) {
		this.itemReview = itemReview;
	}
	public ItemDetails getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(ItemDetails itemDetails) {
		this.itemDetails = itemDetails;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
