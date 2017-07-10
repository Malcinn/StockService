package com.company.stockservice.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.company.stockservice.model.MutableProduct;
import com.company.stockservice.model.Product;

public class StockClassProductDAO implements ProductDAO {

	private static final int FAILURE_CODE = -1;

	private List<Product> products = new ArrayList<Product>();

	private Integer nextProductIndex = 1;

	@Override
	public String insertProduct(Product product) {
		MutableProduct mutableProduct = (MutableProduct) product;
		mutableProduct.settId(nextProductIndex.toString());
		nextProductIndex++;
		boolean isInserted = products.add(product);
		if (isInserted) {
			return product.getId();
		}
		return null;
	}

	@Override
	public boolean deleteProduct(Product product) {
		return products.remove(product);
	}

	@Override
	public Product findProduct(Product product) {
		int indexOfProduct = products.indexOf(product);
		if (indexOfProduct != FAILURE_CODE)
			return products.get(indexOfProduct);
		return null;
	}

	@Override
	public boolean updateProduct(Product product) {
		int indexOfProduct = products.indexOf(product);
		if (indexOfProduct != FAILURE_CODE) {
			MutableProduct mutableProduct = (MutableProduct) products.get(indexOfProduct);
			mutableProduct.settId(product.getId());
			mutableProduct.setName(product.getName());
			mutableProduct.setPrice(product.getPrice());
			return true;
		}
		return false;
	}

	@Override
	public Collection<Product> getAllProducts() {
		return products;
	}

}
