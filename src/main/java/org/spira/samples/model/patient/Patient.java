package org.spira.samples.model.patient;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.jboss.logging.Logger;
import org.spira.samples.model.SampleType;

import javax.enterprise.inject.Model;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

/**
 * Model containing all data collected for each sample.
 * Here we store all sample metadata such as mobile phone org.spira.samples.model(?) and browser used.
 * Relevant data for ML models (besides audio binary data) is stored on collector attribute
 */
@Model
@MongoEntity(collection = "samples")
public class Patient extends PanacheMongoEntity {

    private static Logger LOGGER = Logger.getLogger(Patient.class);

    @JsonCreator
    public Patient(@JsonProperty("collector") CollectData collector) {
        Instant now = Instant.now();
        this.timestamp = now.toEpochMilli();
        this.collector = collector;
        this.collector.setCollectionDate(LocalDateTime.ofInstant(now, ZoneId.systemDefault()));
        this.patientId = this.collector.getHospitalName() + "_" + this.collector.getPatientRgh();
    }

    /**
     * Patient ID should be a combination of colletor RGH + hospital since RGH-only is not unique
     */
    private String patientId;

    private CollectData collector;

    private Long timestamp;

    /**
     * DB should store only audio paths. The actual binary files are stored in the filesystem
     */
    private Map<String, String> audios;

    public String getAudioFileName(SampleType type) {
        return this.collector.getFormattedDateTime() + "_" + this.collector.getHospitalName() + "_"
                + this.collector.getPatientRgh() + "_" +
                type + ".wav";
    }

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

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, String> getAudios() {
        return audios;
    }

    public void initAudios() {
        this.audios = new HashMap<>();
    }

    public void setAudio(SampleType type, String audioPath) {
        this.audios.put(type.toString(), audioPath);
    }

}
