package com.company.stockservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MutableProductImpl implements MutableProduct {

	private String id;

	private String name;

	private Double price;

	public MutableProductImpl() {
	}

	public MutableProductImpl(String id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	@Override
	public void settId(String id) {
		this.id = id;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "{id : " + id + ", name : " + name + ", price : " + price + "}";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof Product) {
			Product product = (Product) obj;
			if (this.getId().equals(product.getId()))
				return true;
		}
		return false;
	}
}
