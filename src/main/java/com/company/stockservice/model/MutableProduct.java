package com.company.stockservice.model;

/**
 * This interface ensures modification on Product object
 * 
 * @author Malcinn
 *
 */
public interface MutableProduct extends Product {

	public void settId(String id);

	public void setName(String name);

	public void setPrice(Double price);
}
