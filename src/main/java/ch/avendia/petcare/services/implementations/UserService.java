package ch.avendia.petcare.services.implementations;

import ch.avendia.petcare.entities.Client;
import ch.avendia.petcare.entities.transfer.BasicRequestDTO;
import ch.avendia.petcare.entities.transfer.BasicResponseDTO;
import ch.avendia.petcare.entities.transfer.Status;
import com.google.inject.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
@Produces("application/json")
@Consumes({"application/xml", "application/json"})
public class UserService extends BasicService {


    @GET
    @Path("{action}/{id}")
    public Response printMessage(@PathParam("action") String msg, @PathParam("id") String id) {
        String result = "Restful example: " + msg + "<br/>ID: " + id;
        return Response.status(200).entity(result).build();
    }

    @POST
    @Path("save/")
    public BasicResponseDTO saveUser(BasicRequestDTO<Client> u) {
        check(u);

        BasicResponseDTO<Client> response = new BasicResponseDTO<Client>();

        u.getData().setId(1234L);
        u.getData().setUsername("test");

        response.setData(u.getData());
        response.setStatus(Status.SUCCESS);

        return response;
    }

}
