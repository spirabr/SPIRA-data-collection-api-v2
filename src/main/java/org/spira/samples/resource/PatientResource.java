package org.spira.samples.resource;

import org.jboss.logging.Logger;
import org.spira.samples.model.SampleType;
import org.spira.samples.model.audio.AudioForm;
import org.spira.samples.model.patient.Patient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.spira.samples.repository.PatientRepository;
import org.spira.common.service.FilesService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

import static javax.ws.rs.core.Response.Status.*;

@Path("/patient")
@RequestScoped
public class PatientResource {

    private static final Logger LOGGER = Logger.getLogger(PatientResource.class);

    @Inject
    PatientRepository dbService;

    @Inject
    FilesService filesService;

    @GET
    public List<Patient> allPatients() {
        return dbService.fetchAllPatients();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertPatient(@Context Request request, Patient patient) {
        if (patient.validate()) {
            patient.persist();
            LOGGER.info("Patient data saved successfully");
            return Response.status(CREATED)
                    .build();
        } else {
            LOGGER.error("Error saving patient data");
            return Response.status(BAD_REQUEST)
                    .entity("Collector data is invalid")
                    .build();
        }

    }

    @PUT
    @Transactional
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/{hospital}/{rgh}/audio")
    public Response savePatientAudios(@Context Request request, @MultipartForm AudioForm form,
                                      @PathParam("hospital") String hospital, @PathParam("rgh") String rgh) throws IOException {
        Patient patient = findPatient(rgh, hospital);
        if (patient == null) {
            return notFound();
        } else if (patient.getAudios() == null) {
            patient.initAudios();
        }

        for (SampleType type : SampleType.values()) {
            byte[] data = form.get(type);
            String audioFileName = patient.getAudioFileName(type);
            filesService.saveTo(audioFileName, data);
            patient.setAudio(type, filesService.getRootPath() + "/" + audioFileName);
            patient.update();
        }
        return Response.status(OK).build();
    }

    @GET
    @Path("{hospital}/{rgh}")
    public Response getPatient(@Context Request request, @PathParam("hospital") String hospital, @PathParam("rgh") String rgh) {
        Patient patient = findPatient(rgh, hospital);
        return Response.status(OK)
                .entity(patient)
                .build();
    }

    @DELETE
    @Transactional
    @Path("{hospital}/{rgh}")
    public Response deletePatient(@Context Request request, @PathParam("hospital") String hospital, @PathParam("rgh") String rgh) {
        Patient patient = findPatient(rgh, hospital);
        if (patient == null) {
            return notFound();
        }
        patient.delete();
        return Response.status(OK).build();
    }

    private Patient findPatient(String rgh, String hospital) {
        return dbService.find("{ 'collector.patientRgh' : ?1, 'collector.hospitalName' : ?2 } }", rgh, hospital).firstResult();
    }

    private Response notFound() {
        String message = "Patient not found";
        LOGGER.warn(message);
        return Response.status(NOT_FOUND)
                .entity(message)
                .build();
    }
}
