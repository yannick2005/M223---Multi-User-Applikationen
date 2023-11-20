package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;

import ch.zli.m223.model.Room;
import ch.zli.m223.service.RoomService;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/room")
@Tag(name = "Room", description = "Handling of room")
public class RoomController {
    @Inject
    private RoomService roomService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "gets all rooms")
    @RolesAllowed({ "admin", "member" })
    public List<Room> list() {
        return roomService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "get room by id")
    @RolesAllowed({ "admin" })
    public Room find(@PathParam("id") int id) {
        return roomService.findById(id);
    }

    @POST
    @RolesAllowed({ "admin" })
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Room create(Room room) {
        return roomService.createRoom(room);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "update room")
    @RolesAllowed({ "admin" })
    public Room update(@PathParam("id") int id, Room room) {
        return roomService.updateRoom(id, room);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "delete room")
    @RolesAllowed({ "admin" })
    public void delete(@PathParam("id") int id) {
        roomService.deleteRoom(id);
    }

}
