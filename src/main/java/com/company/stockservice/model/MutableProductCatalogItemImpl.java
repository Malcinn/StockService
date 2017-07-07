package com.company.stockservice.model;

public class MutableProductCatalogItemImpl implements MutableProductCatalogItem {

	private Product product;

	private Integer amount;

	public MutableProductCatalogItemImpl(Product product, Integer amount) {
		this.product = product;
		this.amount = amount;
	}

	@Override
	public Product getProduct() {
		return product;
	}

	@Override
	public Integer getAmount() {
		return amount;
	}

	@Override
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return product.toString() + ", {amount : " + amount + "}";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof ProductCatalogItem) {
			ProductCatalogItem productCatalogItem = (ProductCatalogItem) obj;
			if (this.getProduct().equals(productCatalogItem.getProduct()))
				return true;
		}
		return false;
	}
}
