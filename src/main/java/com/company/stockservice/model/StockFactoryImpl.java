package com.company.stockservice.model;

public class StockFactoryImpl implements StockFactory {

	@Override
	public Product createProduct(String id, String name, Double price) {
		return new MutableProductImpl(id, name, price);
	}

	@Override
	public ProductCatalogItem createProductCatalogItem(Product product, Integer amount) {
		return new MutableProductCatalogItemImpl(product, amount);
	}

	@Override
	public ProductCatalogItem createProductCatalogItem(String id, String name, Double price, Integer amount) {
		return new MutableProductCatalogItemImpl(new MutableProductImpl(id, name, price), amount);
	}

}
