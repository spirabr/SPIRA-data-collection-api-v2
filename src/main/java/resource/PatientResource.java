package resource;

import model.patient.Patient;
import repository.PatientRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.util.List;

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
}
