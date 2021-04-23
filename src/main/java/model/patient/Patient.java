package model.patient;


import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import model.SampleType;

import javax.enterprise.inject.Model;
import java.util.Map;

@Model
@MongoEntity(collection = "samples")
public class Patient extends PanacheMongoEntity {

    /**
     * Patient ID should be a combination of colletor RGH + hospital since RGH-only is not unique
     */
    private String patientId;

    private CollectData collector;

    /**
     * DB should store only audio paths. The actual binary files are stored in the filesystem
     */
    private Map<SampleType, String> audios;

    //TODO: Better validation
    public Boolean validate() {
        return this.collector != null && this.collector.getPatientRgh() != null && this.collector.getHospitalName() != null;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public CollectData getCollector() {
        return collector;
    }

    public void setCollector(CollectData collector) {
        this.collector = collector;
    }

    public Map<SampleType, String> getAudios() {
        return audios;
    }

    public void setAudios(Map<SampleType, String> audios) {
        this.audios = audios;
    }
}
