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

    private String sampleType;

    private String gender;

    private Integer age;

    private RespiratoryInsufficiencySituation respiratoryInsufficiencySituation;

    private String CID;

    private Integer respiratoryFrequency;

    // TODO: Check for a better way to identify hospital (maybe create an id?)
    private String hospitalName;

    private LocalDateTime collectionDate;

    private MaskType maskType;

    private CovidSituation covidSituation;

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

    public CovidSituation getCovidSituation() {
        return covidSituation;
    }

    public void setCovidSituation(CovidSituation covidSituation) {
        this.covidSituation = covidSituation;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RespiratoryInsufficiencySituation getRespiratoryInsufficiencySituation() {
        return respiratoryInsufficiencySituation;
    }

    public void setRespiratoryInsufficiencySituation(RespiratoryInsufficiencySituation respiratoryInsufficiencySituation) {
        this.respiratoryInsufficiencySituation = respiratoryInsufficiencySituation;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public Integer getRespiratoryFrequency() {
        return respiratoryFrequency;
    }

    public void setRespiratoryFrequency(Integer respiratoryFrequency) {
        this.respiratoryFrequency = respiratoryFrequency;
    }
}
