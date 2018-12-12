package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ItemLine;
import com.example.repository.CartRepository;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/cart/{userId}")
public class CartController {

	
	@Autowired
	private CartRepository cartRepository;

	@PostMapping
	public void post(@PathVariable String userId, @RequestBody ItemLine itemLine) {
		cartRepository.addToCart(userId, itemLine);
	}

	@GetMapping
	public List<ItemLine> post(@PathVariable String userId) {
		return cartRepository.findAll(userId);
	}

}
