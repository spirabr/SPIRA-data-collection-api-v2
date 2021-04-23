package model.patient;

import org.bson.codecs.pojo.annotations.BsonProperty;

import javax.enterprise.inject.Model;
import java.time.LocalDate;

@Model
public class CollectData {

    @BsonProperty("rgh")
    private String patientRgh;

    @BsonProperty("hospital")
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
