package ch.avendia.petcare.services.endpoints;

import ch.avendia.petcare.entities.Client;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserService {

    @GET
    @Path("{action}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response printMessage(@PathParam("action") String msg, @PathParam("id") String id) {
        String result = "Restful example: " + msg + "<br/>ID: " + id;
        return Response.status(200).entity(result).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveUser(Client u) {


        return Response.status(200).entity("test").build();
    }

}
