package com.company.stockservice.model;

public interface MutableProductCatalogItem extends ProductCatalogItem {

	public void setProduct(Product product);

	public void setAmount(Integer amount);
}
