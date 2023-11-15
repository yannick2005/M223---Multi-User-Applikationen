package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.ws.rs.Path;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.service.AuthentificationService;

@Path("/authentification")
@Tag(name = "Authenitification", description = "")
public class AuthentificationController {
    @Inject
    AuthentificationService authentificationService;
}
