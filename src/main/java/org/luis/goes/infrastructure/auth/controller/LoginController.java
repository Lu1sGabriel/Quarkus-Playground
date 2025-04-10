package org.luis.goes.infrastructure.auth.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.luis.goes.infrastructure.auth.service.LoginService;

@Path(value = "/api/login")
public class LoginController {

    @Inject
    LoginService loginService;

    @POST()
    @Path(value = "/{email}")
    public Response login(@PathParam(value = "email") String email) {
        var token = loginService.login(email);
        return Response.ok(token).build();
    }
}
