package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
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
    @Operation(summary = "gets all bookings")
    @RolesAllowed({ "admin", "member" })
    public List<Booking> getAllBookings() {
        return bookingService.findAll();
    }

    @GET
    @Path("/own")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "get own bookings")
    @RolesAllowed({"admin", "member"})
    public List<Booking> getOwnBooking() {
        return bookingService.findOwn();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "create booking")
    @RolesAllowed({ "admin", "member" })
    public Booking createBooking(Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "update  booking")
    @RolesAllowed({ "admin" })
    public Booking updateBooking(@PathParam("id") int id, Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "deletes booking")
    @RolesAllowed({ "admin", "member" })
    public void deleteBooking(@PathParam("id") int id) {
        bookingService.deleteBooking(id);
    }
}
