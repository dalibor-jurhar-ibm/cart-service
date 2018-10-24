package com.labs.game.cartservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "cartitems")
public class CartItem {
	@Id
	private Integer id;
	@Column
	private String customer;
	@Column
	private String product;

	public CartItem() {

	}

	public CartItem(int id, String customer, String product, int quantity) {
		this.id = id;
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column
	private int quantity;
}