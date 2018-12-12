package com.cubic.providers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cubic.exception.ProductAlreadyExistsException;
import com.cubic.rest.ErrorType;

@Provider
public class ProductAlreadyExistsExceptionProvider extends AbstractExceptionProvider
		implements ExceptionMapper<ProductAlreadyExistsException> {

	public Response toResponse(ProductAlreadyExistsException exception) {
		return this.createResponse(ErrorType.RECORD_ALREADY_EXIXTS, exception);
	}

}
