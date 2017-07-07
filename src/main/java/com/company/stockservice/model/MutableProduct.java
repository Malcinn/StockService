package com.company.stockservice.model;

public interface MutableProduct extends Product {

	public void settId(String id);

	public void setName(String name);

	public void setPrice(Double price);
}
