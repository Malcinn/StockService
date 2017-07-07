package com.company.stockservice.model;

public interface ProductFactory {

	public Product createProduct();

	public Product createProduct(String id, String name, String price);
}
