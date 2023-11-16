package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;

import ch.zli.m223.model.Room;
import ch.zli.m223.service.RoomService;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/room")
@Tag(name = "Room", description = "Handling of room")
public class RoomController {
    @Inject
    private RoomService roomService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin", "member"})
    public List<Room> list() {
        return roomService.findAll();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public Room find(@PathParam("id") Long id) {
        return roomService.findById(id);
    }

    @Path("/{id}")
    @RolesAllowed({"admin"})
    @PUT
    public Room update(@PathParam("id") Long id, Room room){
        return roomService.updateRoom(id, room);
    }

    @Path("/{id}")
    @RolesAllowed({"admin"})
    @DELETE
    public void delete(@PathParam("id") Long id) {
        roomService.deleteRoom(id);
    }
    @POST
    @RolesAllowed({"admin"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Room create(Room room) {
        return roomService.createRoom(room);
    }
}
