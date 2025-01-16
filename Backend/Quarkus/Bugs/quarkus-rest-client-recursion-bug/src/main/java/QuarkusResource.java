import io.smallrye.mutiny.Multi;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Arrays;
import java.util.List;

@Path("/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuarkusResource {
    @Inject
    @RestClient
    ReactiveRestClient reactiveRestClient;

    private List<String> myList = Arrays.asList("Item 1", "Item 2");

    @GET
    @Path("/strings")
    public Response getSomeStrings() {
        return Response.ok(myList).build();
    }

    @GET
    @Path("/api/reactive-strings")
    public Multi<String> apiCall() {
        return reactiveRestClient.getSomeList().onItem().transformToMulti(list -> Multi.createFrom().iterable(list));
    }
}
