package ch.zli.m223.controller;

import ch.zli.m223.model.Role;
import ch.zli.m223.service.RoleService;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/role")
@Tag(name = "Role", description = "Handling of roles")
public class RoleController {
        @Inject
        RoleService roleService;
    
        @GET
        @Path("/all")
        @Produces(MediaType.APPLICATION_JSON)
        @RolesAllowed("admin")
        public List<Role> getAllRoles() {
            return roleService.listAll();
        }

        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        @RolesAllowed("admin")
        public Role getRole(@PathParam("id") Long id) {
            return roleService.findById(id);
        }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @RolesAllowed("admin")
        public Role createRole(Role role) {
            return roleService.create(role);
        }

        @PUT
        @Path("/{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @RolesAllowed("admin")
        public Role updateRole(@PathParam("id") Long id, Role role) {
            return roleService.update(id, role);
        }

        @DELETE
        @Path("/{id}")
        @RolesAllowed("admin")
        public void deleteRole(@PathParam("id") Long id) {
            roleService.delete(id);
        }
}
