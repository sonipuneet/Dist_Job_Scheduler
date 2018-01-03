package com.puneetsoni.djs;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.dropwizard.jersey.errors.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class JsonProcessingExceptionMapper implements ExceptionMapper<JsonProcessingException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonProcessingExceptionMapper.class);

    @Override
    public Response toResponse(JsonProcessingException exception) {
        LOGGER.warn(exception.getMessage());
        if (exception instanceof JsonGenerationException) {
            LOGGER.warn("Error generating JSON", exception);
            return Response
                    .serverError()
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .entity(new ErrorMessage(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                            "Error generating JSON",
                            exception.getOriginalMessage()))
                    .build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}