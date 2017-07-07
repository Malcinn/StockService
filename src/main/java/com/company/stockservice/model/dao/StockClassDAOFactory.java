package com.company.stockservice.model.dao;

public class StockClassDAOFactory extends StockDAOFactory {

	@Override
	public ProductDAO getProductDAO() {
		return new StockClassProductDAO();
	}

	@Override
	public ProductCatalogItemDAO getProductCatalogItemDAO() {
		return new StockClassProductCatalogItemDAO();
	}

}
