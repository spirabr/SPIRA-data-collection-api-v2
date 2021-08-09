package org.spira.samples.model.hospital;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import javax.enterprise.inject.Model;

@Model
@MongoEntity(collection = "hospital")
public class Hospital extends PanacheMongoEntity {

    private Long id;

    private String hospitalName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
