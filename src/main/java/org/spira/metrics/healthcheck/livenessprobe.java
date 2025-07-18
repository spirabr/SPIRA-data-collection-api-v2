package org.spira.metrics.healthcheck;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("metrics/liveness")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class livenessprobe {

    @GET
    public Response handleNotifications() {
        return Response.ok().build();
    }

}
