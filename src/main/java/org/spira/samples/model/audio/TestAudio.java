package org.spira.samples.model.audio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.jboss.resteasy.annotations.providers.multipart.PartType;
import org.spira.samples.model.patient.CollectData;

import javax.enterprise.inject.Model;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Model
@MongoEntity(collection = "testSamples")
public class TestAudio extends PanacheMongoEntity {

    @JsonCreator
    public TestAudio(@JsonProperty("audio") CollectData collector) {
        Instant now = Instant.now();
        this.timestamp = now.toEpochMilli();
        this.collector = collector;
        this.collector.setCollectionDate(LocalDateTime.ofInstant(now, ZoneId.systemDefault()));
        this.patientId = this.collector.getHospitalName() + "_" + this.collector.getPatientRgh();
    }

    @FormParam("audio")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private byte[] data;

    public Boolean validate() {
        return data.length > 0;
    };

    public byte[] getAudioData() {
        return data;
    }
}
