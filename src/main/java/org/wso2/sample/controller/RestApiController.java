package org.wso2.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wso2.sample.model.CheckinInfo;
import org.wso2.sample.model.CheckinInfoDTO;
import org.wso2.sample.service.FlightCheckinService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/api")
public class RestApiController {

    @Autowired
    private FlightCheckinService flightCheckinService;

    @GET
    @Path("/checkin/{bookingReference}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCheckInDetails(@PathParam("bookingReference") String bookingReference) {
        if (flightCheckinService.isCheckInExists(bookingReference)) {
            CheckinInfo checkInDetails = flightCheckinService.getCheckIn(bookingReference);

            return Response.ok().entity(checkInDetails).build();
        } else {
            return Response.noContent().entity("CheckIn details do not exist for bookingReference " + bookingReference).build();
        }

    }

    @POST
    @Path("/checkin")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCheckInDetails(CheckinInfoDTO checkinInfoDTO) {
        flightCheckinService.addCheckIn(checkinInfoDTO.bookingReference, checkinInfoDTO.checkInDetails);

        return Response.ok().entity(checkinInfoDTO).build();
    }
}
