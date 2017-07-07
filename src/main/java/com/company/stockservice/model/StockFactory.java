package com.company.stockservice.model;

/**
 * Abstract Factory of different kind of object factories.
 * 
 * @author Malcinn
 *
 */
public interface StockFactory {

	public ProductFactory getProductFactory();

	public ProductCatalogItemFactory getProductCatalogItemFactory();
}
