package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

@Path("/booking")
@Tag(name = "Booking", description = "Handling of bookings")
public class BookingController {
    @Inject
    BookingService bookingService;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("member")
    public List<Booking> getAllBookings(){
        return bookingService.listAll();
    }
}
