package resource;

import model.patient.Patient;
import repository.PatientRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
}
