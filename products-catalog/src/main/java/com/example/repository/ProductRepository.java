package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Product;
import com.example.model.Review;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByPrice(double price);

	@Query("from Review rev where rev.product.id=:id")
	List<Review> findReviewsByProductId(int id);

}
