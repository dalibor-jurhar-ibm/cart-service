package com.labs.game.cartservice;

import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<CartItem, Integer> {
	CartItem[] findByCustomer(String customer);
}
