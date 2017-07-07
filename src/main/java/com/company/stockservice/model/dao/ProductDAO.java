package com.company.stockservice.model.dao;

import java.util.Collection;

import com.company.stockservice.model.Product;

public interface ProductDAO {

	public int insertProduct(Product product);

	public boolean deleteProduct(Product product);

	public Product findProduct(Product product);

	public boolean updateProduct(Product product);

	public Collection<Product> getAllProducts();
}
