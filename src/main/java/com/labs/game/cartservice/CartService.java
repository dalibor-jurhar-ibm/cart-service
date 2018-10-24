package com.labs.game.cartservice;

import org.springframework.stereotype.Service;

@Service
public class CartService {
	private CartRepository repository;

	public CartService(CartRepository repository) {
		this.repository = repository;
	}

	public CartItem[] findByCustomer(String customer) {
		final CartItem[] cartItems = repository.findByCustomer(customer);
		if (cartItems == null)
			return new CartItem[0];
		else
			return cartItems;
	}
}