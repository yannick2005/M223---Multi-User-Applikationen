package ch.zli.m223.controller;

import ch.zli.m223.model.User;
import ch.zli.m223.service.AuthentificationService;
import ch.zli.m223.service.UserService;

import org.eclipse.microprofile.jwt.JsonWebToken;
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

        @Inject
        UserService userService;

        @Inject
        JsonWebToken jwt; 

        @POST
        @Path("/login")
        @PermitAll
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Operation(summary = "checks the data")
        public String login(@QueryParam("email")String email, @QueryParam("password") String password) {
            return authentificationService.login(email, password);
        }

        @POST
        @Path("/register")
        @PermitAll
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Operation(summary = "create", description = "registered a new User")
        public User register(User user) {
            return userService.createUser(user);
        }

        @POST
        @Path("/logout")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Operation(summary = "log user out")
        public Response logout(String token) {
            return Response.ok(authentificationService.logout(token)).build();
        }
}
