package model.patient;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.codecs.pojo.annotations.BsonProperty;

import javax.enterprise.inject.Model;
import java.time.LocalDate;

@Model
public class CollectData {

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
}
