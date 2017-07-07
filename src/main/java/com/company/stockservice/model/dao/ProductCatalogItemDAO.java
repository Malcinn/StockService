package com.company.stockservice.model.dao;

import java.util.Collection;

import com.company.stockservice.model.Product;
import com.company.stockservice.model.ProductCatalogItem;

public interface ProductCatalogItemDAO {

	public int insertProductCatalogItem(ProductCatalogItem productCatalogItem);

	public boolean deleteProductCatalogItem(ProductCatalogItem productCatalogItem);

	public Product findProductCatalogItem(ProductCatalogItem productCatalogItem);

	public boolean updateProductCatalogItem(ProductCatalogItem productCatalogItem);

	public Collection<Product> getAllProductCatalogItems();
}
