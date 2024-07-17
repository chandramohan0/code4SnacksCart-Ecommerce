package com.chandraMohan.code4SnacksCart.dal;

import org.springframework.data.repository.CrudRepository;

import com.chandraMohan.code4SnacksCart.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
