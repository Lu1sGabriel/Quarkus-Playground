package org.luis.goes.infrastructure.presentation.controller.user;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.luis.goes.domain.entitite.user.UserEntity;
import org.luis.goes.domain.service.user.UserService;

import java.util.UUID;

@Path(value = "/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path(value = "/{id}")
    public Response getById(@PathParam(value = "id") UUID id) {
        var user = userService.getById(id);
        return Response.ok(user).build();
    }

    @GET
    public Response getAll(@QueryParam(value = "page") @DefaultValue("0") Integer page,
                           @QueryParam(value = "pageSize") @DefaultValue("10") Integer pageSize) {
        var userList = userService.getAll(page, pageSize);
        return Response.ok(userList).build();
    }

    @POST
    public Response create(UserEntity userEntity) {
        return Response.ok(userService.create(userEntity)).build();
    }

}