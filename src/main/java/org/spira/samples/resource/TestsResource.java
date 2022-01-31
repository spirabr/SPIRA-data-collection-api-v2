package org.spira.samples.resource;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.spira.samples.model.audio.TestAudio;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("test")
public class TestsResource {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response insertTestAudio(@Context Request request, @MultipartForm TestAudio testAudio) {
        try {
            if (testAudio.validate()) {
                testAudio.persist();
                return Response.status(200).build();
            }
            else {
                return Response.status(402).entity("Audio vazio").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity(e.toString()).build();
        }
    }

}
