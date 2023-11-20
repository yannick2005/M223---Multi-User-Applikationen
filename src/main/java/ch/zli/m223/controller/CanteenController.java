package ch.zli.m223.controller;

import ch.zli.m223.model.Canteen;
import ch.zli.m223.service.CanteenService;
import javax.annotation.security.RolesAllowed;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/product")
@Tag(name = "Canteen", description = "Handling of canteens")

public class CanteenController {

    @Inject
    CanteenService canteenService;

    @GET
    @Path("/all")
    @RolesAllowed({ "admin" })
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "gets all products")
    public List<Canteen> list() {
        return canteenService.findAll();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "admin", "member" })
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "gets product by id")
    public Canteen get(@PathParam("id") int id) {
        return canteenService.findById(id);
    }

    @POST
    @RolesAllowed({ "admin" })
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "creates product")
    public Canteen add(Canteen canteen) {
        return canteenService.createCanteen(canteen);
    }

    @DELETE
    @Path("{id}")
    @RolesAllowed({ "admin" })
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "deletes booking")
    public void delete(@PathParam("id") int id) {
        canteenService.deleteCanteen(id);
    }
}
