package com.example.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.ItemLine;

@Repository
public class CartRepositoryImpl implements CartRepository {

	// inject the actual template
	@Autowired
	private RedisTemplate<String, String> template;

	// inject the template as ListOperations
	// can also inject as Value, Set, ZSet, and HashOperations
	@Resource(name = "redisTemplate")
	private ListOperations<String, ItemLine> listOps;

	@Override
	public void addToCart(String user, ItemLine itemLine) {
		//listOps.leftPop(user);
		listOps.leftPush(user, itemLine);
	}

	@Override
	public List<ItemLine> findAll(String user) {
		return listOps.range(user, 0, -1);
	}

}
