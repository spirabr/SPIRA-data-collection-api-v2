package org.spira.metrics.resource;

import org.spira.metrics.service.AudiosService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("metrics/audios")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class AudiosResource {

    @Inject
    AudiosService service;

    @GET
    public List<String> getAudioNames() {
        return service.getAudioNames();
    }
}
