package com.company.stockservice.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.company.stockservice.model.MutableProduct;
import com.company.stockservice.model.MutableProductImpl;
import com.company.stockservice.model.Product;
import com.company.stockservice.model.ProductFactory;
import com.company.stockservice.model.ProductFactoryImpl;
import com.company.stockservice.model.dao.ProductDAO;
import com.company.stockservice.model.dao.StockDAOFactory;
import com.company.stockservice.model.dao.StockDAOFactoryType;

@Path("/productsService")
public class ProductsService {

	private static final Logger LOGGER = LogManager.getLogger(ProductsService.class);

	private ProductDAO productDAO = StockDAOFactory.getDAOFactory(StockDAOFactoryType.CLASS).getProductDAO();

	private ProductFactory productFactory = new ProductFactoryImpl();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/getAllProducts")
	public List<MutableProductImpl> getAllProducts() {
		List<MutableProductImpl> mutableProductImpls = new ArrayList<MutableProductImpl>();
		for (Product product : productDAO.getAllProducts()) {
			mutableProductImpls.add(new MutableProductImpl(product.getId(), product.getName(), product.getPrice()));
		}
		return mutableProductImpls;
	}

	@PUT
	@Path("/insertProduct")
	public Response insertProductByParams(@QueryParam("id") String id, @QueryParam("name") String name,
			@QueryParam("price") Double price) {
		productDAO.insertProduct(productFactory.createProduct(id, name, price));
		return Response.ok("Object succesfully inserted.").build();
	}

	@DELETE
	@Path("/deleteProduct")
	public Response deleteProductByParams(@QueryParam("id") String id) {
		productDAO.deleteProduct(productFactory.createProduct(id, null, null));
		return Response.ok("Object succesfully deleted.").build();
	}

	@GET
	@Path("/getProduct")
	@Produces(MediaType.APPLICATION_XML)
	public Product getProductByParams(@QueryParam("id") String id) {
		return productDAO.findProduct(productFactory.createProduct(id, null, null));
	}

	@POST
	@Path("/updateProduct")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateProductByParams(@QueryParam("id") String id, @QueryParam("name") String name,
			@QueryParam("price") Double price) {
		Product product = productDAO.findProduct(productFactory.createProduct(id, name, price));
		if (null != product) {
			MutableProduct mutableProduct = (MutableProduct) product;
			mutableProduct.setName(name);
			mutableProduct.setPrice(price);
			productDAO.updateProduct(mutableProduct);
			return Response.ok().build();
		} else {
			LOGGER.info("Product not found. No update will be procesed.");
		}
		return Response.notModified().build();
	}
	
	
}
