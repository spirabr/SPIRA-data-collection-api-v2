package model.audio;

import model.SampleType;
import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

public class AudioForm {

    @FormParam("aceite")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private byte[] aceiteData;

    @FormParam("sustentada")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private byte[] sustentadaData;

    @FormParam("parlenda")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private byte[] parlendaData;

    @FormParam("frase")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private byte[] fraseData;

    public byte[] get(SampleType type) {
        switch (type) {
            case ACEITE: return getAceiteData();
            case SUSTENTADA: return getSustentadaData();
            case PARLENDA: return getParlendaData();
            case FRASE: return getFraseData();
        }
        return null;
    }

    public byte[] getAceiteData() {
        return aceiteData;
    }

    public byte[] getSustentadaData() {
        return sustentadaData;
    }

    public byte[] getParlendaData() {
        return parlendaData;
    }

    public byte[] getFraseData() {
        return fraseData;
    }
}
