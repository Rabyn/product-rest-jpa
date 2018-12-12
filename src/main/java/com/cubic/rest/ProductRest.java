package com.cubic.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cubic.services.ProductService;

@Path("/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Service
public class ProductRest {

	@Autowired
	@Qualifier("jpaPS")
	private ProductService ps;

	@POST
	@Path("/create")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createProduct(final Product prod) {
		String pk = ps.createProduct(prod);
		prod.setId(pk);
		return Response.ok().entity(prod).build();
	}

	@DELETE
	@Path("/remove/{id}")
	public Response removeProduct(@PathParam("id") final String pk) {
		ps.removeProduct(pk);
		return Response.noContent().build();
	}

	@GET
	@Path("/{upc}")
	public Response findProduct(@PathParam("upc") final String upc) {
		Product result = ps.findProduct(upc);
		return Response.ok().entity(result).build();
	}

	@PUT
	@Path("/modify")
	public Response modifyProduct(final Product prod) {
		ps.modifyProduct(prod);
		return Response.noContent().build();
	}

	@GET
	@Path("/search/{searchStr}")
	public Response searchProduct(@PathParam("searchStr") final String searchStr) {
		List<Product> searchResults = ps.searchProduct(searchStr);
		return Response.ok().entity(new ProductSearchResult(searchResults)).build();
	}

	@GET
	@Path("/search")
	public Response searchAllProduct() {
		List<Product> searchResults = ps.searchAllProduct();
		return Response.ok().entity(new ProductSearchResult(searchResults)).build();
	}
}
