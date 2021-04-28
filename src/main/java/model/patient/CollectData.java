package model.patient;

import javax.enterprise.inject.Model;
import java.time.LocalDate;

/**
 * Model containing relevant data for ML models (besides audio binary data)
 */
@Model
public class CollectData {

    private String patientRgh;

    // TODO: Check for a better way to identify hospital (maybe create an id?)
    private String hospitalName;

    private LocalDate collectionDate;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getPatientRgh() {
        return patientRgh;
    }

    public void setPatientRgh(String patientRgh) {
        this.patientRgh = patientRgh;
    }
}
