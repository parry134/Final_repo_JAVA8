package com.example.web;

import java.util.Arrays;
import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.ItemLine;
import com.example.model.Order;
import com.example.model.OrderStatus;
import com.example.repository.OrderRepository;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping
	public List<Order> getAll() {
		return orderRepository.findAll();
	}

	@PostMapping("/{userId}")
	public Order post(@PathVariable String userId) {

		RestTemplate restTemplate = new RestTemplate();
		String cartServiceUrl = "http://localhost:8383/api/cart/" + userId;

		ResponseEntity<ItemLine[]> responseEntity = restTemplate.getForEntity(cartServiceUrl, ItemLine[].class);
		ItemLine[] itemLines = responseEntity.getBody();
		
		double totalAmount=Arrays
		.stream(itemLines)
		.mapToDouble(ItemLine::getPrice)
		.sum();

		Order order=new Order();
		order.setStaus(OrderStatus.ACTIVE);
		order.setTotal_amount(totalAmount);
		
		return orderRepository.save(order);
		

	}

}
