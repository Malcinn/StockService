package com.company.stockservice.model;

public interface ProductCatalogItemFactory {

	public ProductCatalogItem createProductCatalogItem();

	public ProductCatalogItem createProductCatalogItem(Product product, Integer amount);
}
