package org.spira.samples.model.patient;

import javax.enterprise.inject.Model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Model containing relevant data for ML models (besides audio binary data)
 */
@Model
public class CollectData {

    private String patientRgh;

    // TODO: Check for a better way to identify hospital (maybe create an id?)
    private String hospitalName;

    private LocalDateTime collectionDate;

    private MaskType maskType;

    private CovidStatus covidStatus;

    private Double saturacaoOxigenio;

    private Integer bpm;

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

    public LocalDateTime getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(LocalDateTime collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getFormattedDateTime() {
        return this.collectionDate.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public MaskType getMaskType() {
        return maskType;
    }

    public void setMaskType(MaskType maskType) {
        this.maskType = maskType;
    }

    public CovidStatus getCovidStatus() {
        return covidStatus;
    }

    public void setCovidStatus(CovidStatus covidStatus) {
        this.covidStatus = covidStatus;
    }

    public Double getSaturacaoOxigenio() {
        return saturacaoOxigenio;
    }

    public void setSaturacaoOxigenio(Double saturacaoOxigenio) {
        this.saturacaoOxigenio = saturacaoOxigenio;
    }

    public Integer getBpm() {
        return bpm;
    }

    public void setBpm(Integer bpm) {
        this.bpm = bpm;
    }
}
