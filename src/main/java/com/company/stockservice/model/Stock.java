package com.company.stockservice.model;

public interface Stock {

	public void addProductCatalogItem(ProductCatalogItem productCatalogItem);

	public void removeProductCatalogItem(ProductCatalogItem productCatalogItem);

	public ProductCatalogItem getProductCatalogItem(String id);

	public int getAmountOfProductCatalogItems();
}
