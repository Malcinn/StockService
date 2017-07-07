package com.company.stockservice.model.dao;

public abstract class StockDAOFactory {

	public abstract ProductDAO getProductDAO();

	public abstract ProductCatalogItemDAO getProductCatalogItemDAO();

	public static StockDAOFactory getDAOFactory(StockDAOFactoryType stockDAOFactoryType) {
		switch (stockDAOFactoryType) {
		case CLASS:
			return new StockClassDAOFactory();
		case XML:
			return null;
		case DB:
			return null;
		}
		return null;
	}
}
