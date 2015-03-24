package edu.ap.jaxrs;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider //Speciale klasse waar je iets mee kunt doen
public class HelloFilter implements ContainerRequestFilter {

    @Override //Informatieve annotatie
    public void filter(ContainerRequestContext requestContext) throws IOException {
    	System.out.println("Method called : " + requestContext.getMethod());
    }
}
