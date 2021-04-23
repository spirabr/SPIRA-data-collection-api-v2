package resource;

import model.audio.AudioForm;
import model.patient.Patient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import repository.PatientRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.*;

@Path("/patient")
@RequestScoped
public class PatientResource {

    @Inject
    PatientRepository service;

    @GET
    public List<Patient> allPatients() {
        return service.fetchAllPatients();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertPatient(@Context Request request, Patient patient) {
        if (patient.validate()) {
            patient.persist();
            return Response.status(CREATED)
                    .build();
        } else {
            return Response.status(BAD_REQUEST)
                    .entity("Collector data is invalid")
                    .build();
        }

    }

    @PUT
    @Transactional
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/{hospital}/{rgh}/audio")
    public Response savePatientAudios(@Context Request request, @MultipartForm AudioForm form,
                                      @PathParam("hospital") String hospital, @PathParam("rgh") String rgh) {
        Patient patient = findPatient(rgh, hospital);
        if (patient == null) {
            return notFound();
        }

        //TODO: persist audios to disk and update DB
        return Response.status(OK).build();
    }

    @GET
    @Path("{hospital}/{rgh}")
    public Response getPatient(@Context Request request, @PathParam("hospital") String hospital, @PathParam("rgh") String rgh) {
        Patient patient = findPatient(rgh, hospital);
        return Response.status(OK)
                .entity(patient)
                .build();
    }

    @DELETE
    @Transactional
    @Path("{hospital}/{rgh}")
    public Response deletePatient(@Context Request request, @PathParam("hospital") String hospital, @PathParam("rgh") String rgh) {
        Patient patient = findPatient(rgh, hospital);
        if (patient == null) {
            return notFound();
        }
        patient.delete();
        return Response.status(OK).build();
    }

    private Patient findPatient(String rgh, String hospital) {
        return service.find("{ 'collector.patientRgh' : ?1, 'collector.hospitalName' : ?2 } }", rgh, hospital).firstResult();
    }

    private Response notFound() {
        return Response.status(NOT_FOUND)
                .entity("Patient not found")
                .build();
    }
}
