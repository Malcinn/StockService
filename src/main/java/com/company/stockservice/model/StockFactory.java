package com.company.stockservice.model;

public interface StockFactory {

	public Product createProduct(String id, String name, Double price);

	public ProductCatalogItem createProductCatalogItem(Product product, Integer amount);

	public ProductCatalogItem createProductCatalogItem(String id, String name, Double price, Integer amount);
}
