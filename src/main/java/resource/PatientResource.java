package resource;

import model.patient.Patient;
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
import java.util.Optional;

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
            return Response.status(Response.Status.CREATED)
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Collector data is invalid")
                    .build();
        }

    }

    @GET
    @Path("{hospital}/{rgh}")
    public Response getPatient(@Context Request request, @PathParam("hospital") String hospital, @PathParam("rgh") String rgh) {
        Patient patient = findPatient(rgh, hospital);
        return Response.status(Response.Status.OK)
                .entity(patient)
                .build();
    }

    @DELETE
    @Transactional
    @Path("{hospital}/{rgh}")
    public Response deletePatient(@Context Request request, @PathParam("hospital") String hospital, @PathParam("rgh") String rgh) {
        Patient patient = findPatient(rgh, hospital);
        if (patient == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Patient not found")
                    .build();
        }
        patient.delete();
        return Response.status(Response.Status.OK).build();
    }

    private Patient findPatient(String rgh, String hospital) {
        return service.find("{ 'collector.patientRgh' : ?1, 'collector.hospitalName' : ?2 } }", rgh, hospital).firstResult();
    }
}
