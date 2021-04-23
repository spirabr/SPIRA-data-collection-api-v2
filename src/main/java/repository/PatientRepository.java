package repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import model.patient.Patient;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PatientRepository implements PanacheMongoRepository<Patient> {

    public List<Patient> fetchAllPatients() {
        return findAll().list();
    }
}
