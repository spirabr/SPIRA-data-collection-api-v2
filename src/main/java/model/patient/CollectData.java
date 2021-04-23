package model.patient;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.enterprise.inject.Model;
import java.time.LocalDate;

@Model
public class CollectData {

    @JsonProperty("rgh")
    private String patientRgh;

    // TODO: Check for a better way to identify hospital (maybe create an id?)
    @JsonProperty("hospital")
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
