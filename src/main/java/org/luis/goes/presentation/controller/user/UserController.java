package org.luis.goes.presentation.controller.user;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.luis.goes.application.service.user.UserService;
import org.luis.goes.presentation.dto.user.UserRequestDTO;

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
        var user = userService.findById(id);
        return Response.ok(user).build();
    }

    @GET
    public Response getAll(@QueryParam(value = "page") @DefaultValue("0") Integer page,
                           @QueryParam(value = "pageSize") @DefaultValue("10") Integer pageSize) {
        var userList = userService.findAll(page, pageSize);
        return Response.ok(userList).build();
    }

    @POST
    public Response create(UserRequestDTO userRequestDTO) {
        return Response.ok(userService.create(userRequestDTO)).build();
    }

    @PUT
    @Path(value = "/{id}")
    public Response update(@PathParam(value = "id") UUID id, UserRequestDTO userRequestDTO) {
        var user = userService.update(id, userRequestDTO);
        return Response.ok(user).build();
    }

    @DELETE
    @Path(value = "/{id}")
    public Response delete(@PathParam(value = "id") UUID id) {
        userService.delete(id);
        return Response.noContent().build();
    }

}