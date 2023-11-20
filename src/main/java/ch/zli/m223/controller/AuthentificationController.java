package ch.zli.m223.controller;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.service.AuthentificationService;
import ch.zli.m223.service.ApplicationUserService;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
@Tag(name = "Authentification", description = "Authentificates a user")
public class AuthentificationController {
        @Inject
        AuthentificationService authentificationService;
        ApplicationUserService userService;

        @POST
        @Path("/login")
        @PermitAll
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Operation(summary = "logs the user in")
        public Response login(@QueryParam("email")String email, @QueryParam("password") String password) {
            return authentificationService.login(email, password);
        }

        @POST
        @Path("/register")
        @PermitAll
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Operation(summary = "create user", description = "registered a new User")
        public ApplicationUser register(ApplicationUser user) {
            return userService.createUser(user);
        }

        @POST
        @Path("/logout")
        @PermitAll
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Operation(summary = "log user out")
        public Response logout(String token) {
            return authentificationService.logout(token);
        }
}
