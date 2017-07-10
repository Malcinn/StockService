package com.company.stockservice.model;

public class ProductFactoryImpl implements ProductFactory {

	@Override
	public Product createProduct() {
		return new MutableProductImpl(null, null, null);
	}

	@Override
	public Product createProduct(String id, String name, Double price) {
		return new MutableProductImpl(id, name, price);
	}

}
