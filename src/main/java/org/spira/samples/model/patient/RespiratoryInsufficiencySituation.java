package org.spira.samples.model.patient;

public class RespiratoryInsufficiencySituation {

    private RespiratoryInsufficiencyStatus respiratoryInsufficiencyStatus;

    private String location;

    public RespiratoryInsufficiencyStatus getRespiratoryInsufficiencyStatus() {
        return respiratoryInsufficiencyStatus;
    }

    public void setRespiratoryInsufficiencyStatus(RespiratoryInsufficiencyStatus respiratoryInsufficiencyStatus) {
        this.respiratoryInsufficiencyStatus = respiratoryInsufficiencyStatus;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
