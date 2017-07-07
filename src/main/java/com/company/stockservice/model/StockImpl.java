package com.company.stockservice.model;

import java.util.ArrayList;
import java.util.List;

public class StockImpl implements Stock {

	List<ProductCatalogItem> productCatalogItems = new ArrayList<>();

	@Override
	public void addProductCatalogItem(ProductCatalogItem productCatalogItem) {
		productCatalogItems.add(productCatalogItem);
	}

	@Override
	public void removeProductCatalogItem(ProductCatalogItem productCatalogItem) {
		productCatalogItems.remove(productCatalogItem);
	}

	@Override
	public ProductCatalogItem getProductCatalogItem(String id) {
		for (ProductCatalogItem productCatalogItem : productCatalogItems) {
			if (productCatalogItem.getProduct().getId().equals(id))
				return productCatalogItem;
		}
		return null;
	}

	@Override
	public int getAmountOfProductCatalogItems() {
		return productCatalogItems.size();
	}

}
