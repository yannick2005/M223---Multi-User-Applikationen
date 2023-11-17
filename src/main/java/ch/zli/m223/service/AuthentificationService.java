package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.JsonWebToken;

import ch.zli.m223.model.User;

import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class AuthentificationService {
    @Inject
    UserService userService;

    @Inject
    JsonWebToken jwt;

    @Transactional
    public String login(String email, String password) {
        List<User> users = userService.listAll();
        String jwt = "";
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                String token = Jwt.issuer("https://zli.example.com/issuer")
                        .upn(user.getEmail())
                        .groups(user.getRole().getRole())
                        .expiresIn(Integer.MAX_VALUE)
                        .sign();
                jwt = token;

                return jwt;
            }
        }
        throw new IllegalArgumentException("Unauthorized");
    }

    public Response logout(String token) {
        return Response.ok(token).build();
    }
}
