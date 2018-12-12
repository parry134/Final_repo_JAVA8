package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS", schema = "orders_db")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double total_amount;
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private OrderStatus staus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public OrderStatus getStaus() {
		return staus;
	}

	public void setStaus(OrderStatus staus) {
		this.staus = staus;
	}

}
