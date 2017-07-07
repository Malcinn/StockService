package com.company.stockservice.model;

/**
 * This interface ensures modification on ProductCatalogItem object
 * 
 * @author marcin
 *
 */
public interface MutableProductCatalogItem extends ProductCatalogItem {

	public void setProduct(Product product);

	public void setAmount(Double amount);
}
