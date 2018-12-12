package com.example.repository;

import java.util.List;

import com.example.model.ItemLine;

public interface CartRepository {
	
	public void addToCart(String user,ItemLine itemLine);
	public List<ItemLine> findAll(String user);

}
