package org.spira.samples.resource;

import org.jboss.logging.Logger;
import org.spira.samples.model.hospital.Hospital;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("hospital")
public class HospitalResource {

    private static final Logger LOGGER = Logger.getLogger(HospitalResource.class);

    @GET
    public List<Hospital> listHospitals() {
        return Hospital.findAll().list();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response newHospital(Hospital hospital) {
        hospital.setId(Hospital.count() + 1);
        hospital.persist();
        LOGGER.info("New hospital: " + hospital.getHospitalName() + "saved successfully");
        return Response.status(Response.Status.CREATED).build();
    }
}
