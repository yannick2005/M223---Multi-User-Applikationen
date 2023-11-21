package ch.zli.m223.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.JsonWebToken;

import ch.zli.m223.model.ApplicationUser;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class AuthentificationService {
    @Inject
    ApplicationUserService userService;

    @Inject
    JsonWebToken jwt;

    @Transactional
    public Response login(String email, String password) {
        List<ApplicationUser> users = userService.listAll();
        for (ApplicationUser user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                String userRoleAsString = user.getRole().getName();
                String token = Jwt.issuer("https://zli.example.com/issuer")
                        .upn(user.getEmail())
                        .groups(new HashSet<>(Arrays.asList(userRoleAsString))) // A user can only have one role at a time.
                        .expiresIn(Duration.ofHours(24))
                        .sign();
                return Response
                        .ok(user)
                        .cookie(new NewCookie("coworkingspace: ", token))
                        .header("Authorization", "Bearer " + token)
                        .build();
            }
        }
        throw new IllegalArgumentException("Unauthorized");
    }

    public Response logout(String token) {
        return Response.ok(token).build();
    }
}
