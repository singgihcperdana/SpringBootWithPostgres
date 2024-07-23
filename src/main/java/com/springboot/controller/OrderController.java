package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import com.springboot.service.OrderService;
import com.springboot.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	public OrderService service;

	@RequestMapping("/")
	public String index() {
		return "Hello World!";
	}

	@RequestMapping("/findById/{id}")
	public Optional<Order> findById(@PathVariable int id) {

		return service.findById(id);
	}

	@RequestMapping("/findAll")
	public List<Order> findAll() {
		return service.findAll();
	}

	@PostMapping("/createOrder")
	public Order createOrder(){
		return service.createOrder();
	}

}
