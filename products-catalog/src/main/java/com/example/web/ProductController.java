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

import com.example.model.Product;
import com.example.model.Review;
import com.example.repository.ProductRepository;
import com.example.repository.ReviewRepository;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@GetMapping
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@GetMapping("/{id}/reviews")
	public List<Review> getAllReviews(@PathVariable int id) {
		return productRepository.findReviewsByProductId(id);
	}

	@PostMapping("/{id}/reviews")
	public Review postnewreview(@PathVariable int id, @RequestBody Review review) {
		Product product = new Product();
		product.setId(id);
		review.setProduct(product);
		return reviewRepository.save(review);
	}

}
