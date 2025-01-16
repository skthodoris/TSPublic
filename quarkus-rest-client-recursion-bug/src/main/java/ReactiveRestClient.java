import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import java.util.List;

@Path("/v1/db/strings")
@RegisterRestClient(configKey = "string-reactive-client")
public interface ReactiveRestClient {
    @GET
    Uni<List<String>> getSomeList();
}
