package com.chandraMohan.code4SnacksCart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@NamedQuery(name="ItemDetails.findByCategoryOrderByPrice", query = "SELECT itd from ItemDetails itd where itd.category=?1 ORDER BY itd.price DESC")
@Table(name="item_details")
public class ItemDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String brand;
	@Column
	private double price;
	@Column
	private String category;
	
	@OneToOne(mappedBy = "itemDetails", cascade = CascadeType.ALL)
	private Item item;
	
//	public Item getItem() {
//		return item;
//	}
//	public void setItem(Item item) {
//		this.item = item;
//	}
	
	public int getId() {
		return id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
