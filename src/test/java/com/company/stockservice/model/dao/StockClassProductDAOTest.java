package com.company.stockservice.model.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.company.stockservice.model.MutableProduct;
import com.company.stockservice.model.Product;
import com.company.stockservice.model.ProductFactory;
import com.company.stockservice.model.ProductFactoryImpl;

public class StockClassProductDAOTest {

	private StockDAOFactory stockDAOFactory;

	private ProductFactory productFactory = new ProductFactoryImpl();

	@Before
	public void setUp() {
		stockDAOFactory = StockDAOFactory.getDAOFactory(StockDAOFactoryType.CLASS);
	}

	@Test
	public void insertProductTest() {
		ProductDAO productDAO = stockDAOFactory.getProductDAO();
		productDAO.insertProduct(productFactory.createProduct());
		productDAO.insertProduct(productFactory.createProduct());
		String productId = productDAO.insertProduct(productFactory.createProduct());
		Assert.assertTrue(productDAO.getAllProducts().size() > 2);

	}

	@Test
	public void deleteProductTest() {
		ProductDAO productDAO = stockDAOFactory.getProductDAO();
		productDAO.insertProduct(productFactory.createProduct(null, "product1", 11.11));
		String productId = productDAO.insertProduct(productFactory.createProduct(null, "product2", 11.11));
		Product product = productDAO.findProduct(productFactory.createProduct(productId, null, null));
		productDAO.deleteProduct(product);
		Assert.assertTrue(productDAO.getAllProducts().size() == 1);

	}

	@Test
	public void findProducttest() {
		ProductDAO productDAO = stockDAOFactory.getProductDAO();
		productDAO.insertProduct(productFactory.createProduct(null, "product1", 11.11));
		String productId = productDAO.insertProduct(productFactory.createProduct(null, "product2", 11.11));
		Product product = productDAO.findProduct(productFactory.createProduct(productId, null, null));
		Assert.assertTrue(product.getName().equals("product2"));
	}

	@Test
	public void updateProductTest() {
		ProductDAO productDAO = stockDAOFactory.getProductDAO();
		productDAO.insertProduct(productFactory.createProduct(null, "product1", 11.11));
		String productId = productDAO.insertProduct(productFactory.createProduct(null, "product2", 11.11));
		Product product = productDAO.findProduct(productFactory.createProduct(productId, null, null));
		MutableProduct mutableProduct = (MutableProduct) product;
		mutableProduct.setName("name");
		productDAO.updateProduct(mutableProduct);
		product = productDAO.findProduct(product);
		Assert.assertTrue(product.getName().equals("name"));
	}

	@Test
	public void getAllProductsTest() {
		ProductDAO productDAO = stockDAOFactory.getProductDAO();
		productDAO.insertProduct(productFactory.createProduct(null, "product1", 11.11));
	}
}
