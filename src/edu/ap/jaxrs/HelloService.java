package edu.ap.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/ap")
public class HelloService extends ResourceConfig {
	
  // This method is called if TEXT_PLAIN is requested
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    return "Hello, welcome to AP Antwerp.";
  }

  // This method is called if XML is requested
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
    return "<?xml version=\"1.0\"?>" + "<hello> Hello, welcome to AP Antwerp." + "</hello>";
  }

  // This method is called if HTML is requested
  @GET
  @Path("/{name}")
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello(@PathParam("name") String name) {
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello " + name + "</h1></body>" + "</html> ";
  }
  
  @GET
  @Path("{format}/{name}")
  @Produces(MediaType.TEXT_HTML)
  @Compress
  public String sayHtmlHello(@PathParam("format") String format, @PathParam("name") String name) {
	  String retValue = "";
	  if(format.equals("xml")) {
		  retValue = "<?xml version=\"1.0\"?>" + "<hello> Hello " + name + "</hello>";
	  }
	  else if(format.equals("json")) {
		  retValue = "{\"name\" : \"" + name + "\"}";
	  }
	  else if(format.equals("txt")) {
		  retValue = "Hello " + name;
	  }
	  return retValue;
  }
}
