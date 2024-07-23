package com.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.springboot.repository.OrderRepository;
import com.springboot.repository.SequenceGeneratorCustomRepository;
import com.springboot.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository repository;
	private final SequenceGeneratorCustomRepository sequenceGeneratorCustomRepository;

	public Optional<Order> findById(int id) {
		return repository.findById(id);
	}

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order createOrder(){
		return repository.save(Order.builder()
				.name("NAME-" + UUID.randomUUID())
				.refCode(this.generateRefCode())
				.build());
	}

	private String generateRefCode(){
		int length = 14;
		Long orderSequence = sequenceGeneratorCustomRepository.getNextId("orders_seq");
		return "1"+ String.format("%0"+length+"d", orderSequence);
	}

}
