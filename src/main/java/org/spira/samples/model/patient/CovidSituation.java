package org.spira.samples.model.patient;

import java.util.Date;

public class CovidSituation {

    private CovidStatus covidStatus;

    private Date lastPositiveDiagnoseDate;

    private Boolean hospitalized;

    private Date hospitalizationStart;

    private Date hospitalizationEnd;

    public CovidStatus getCovidStatus() {
        return covidStatus;
    }

    public void setCovidStatus(CovidStatus covidStatus) {
        this.covidStatus = covidStatus;
    }

    public Date getLastPositiveDiagnoseDate() {
        return lastPositiveDiagnoseDate;
    }

    public void setLastPositiveDiagnoseDate(Date lastPositiveDiagnoseDate) {
        this.lastPositiveDiagnoseDate = lastPositiveDiagnoseDate;
    }

    public Boolean getHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(Boolean hospitalized) {
        this.hospitalized = hospitalized;
    }

    public Date getHospitalizationStart() {
        return hospitalizationStart;
    }

    public void setHospitalizationStart(Date hospitalizationStart) {
        this.hospitalizationStart = hospitalizationStart;
    }

    public Date getHospitalizationEnd() {
        return hospitalizationEnd;
    }

    public void setHospitalizationEnd(Date hospitalizationEnd) {
        this.hospitalizationEnd = hospitalizationEnd;
    }
}
