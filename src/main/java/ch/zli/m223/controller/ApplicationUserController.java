package ch.zli.m223.controller;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.service.ApplicationUserService;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/user")
@Tag(name = "User", description = "Handling of users")
public class ApplicationUserController {
    @Inject
    ApplicationUserService userService;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public List<ApplicationUser> getAllUsers() {
        return userService.listAll();
    }

    @GET
    @Path("/others")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("member")
    public List<ApplicationUser> seeAllMembers() {
        return userService.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin"})
    public ApplicationUser getUser(@PathParam("id") int id) {
        return userService.findUserById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin"})
    public ApplicationUser createUser(ApplicationUser user) {
        return userService.createUser(user);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin"})
    public ApplicationUser updateUser(@PathParam("id") int id, ApplicationUser user) {
        return userService.updateUser(id, user);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin"})
    public void deleteUser(@PathParam("id") int id) {
        userService.deleteUser(id);
    }
}
