package com.company.stockservice.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloService")
public class HelloService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {
		return "Hello from /helloService";
	}
}
