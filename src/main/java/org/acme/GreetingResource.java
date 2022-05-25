package org.acme;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.reactive.RestResponse;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String helloJson() {
        return "{\"message\": \"Hello from RESTEasy Reactive\"}";
    }

    @GET
    @Path("/map")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<Map<String, String>> helloMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("message", "Hello from RESTEasy Reactive");
        return RestResponse.status(Response.Status.OK, map);
    }
}
