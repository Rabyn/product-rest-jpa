package com.cubic.providers;

import javax.ws.rs.core.Response;

import com.cubic.rest.ErrorInfo;
import com.cubic.rest.ErrorType;

public abstract class AbstractExceptionProvider {
	protected Response createResponse(final ErrorType errortype, final Exception exception) {
		ErrorInfo entity = new ErrorInfo();
		entity.setErrorCode(errortype.name());
		entity.setErrorDesc(exception.getMessage());
		return Response.status(errortype.getCode()).entity(entity).build();
	}
}
