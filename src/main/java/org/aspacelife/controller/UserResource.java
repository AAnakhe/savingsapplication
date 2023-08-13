package org.aspacelife.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aspacelife.model.User;
import org.aspacelife.service.UserService;

import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @GET
    public List<User> listUser() {
       return userService.getAllUser();
    }

    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id") Long id) {
        return userService.getUserById(id);
    }

    @POST
    @Transactional
    public User saveUser(User user) {
        return userService.saveUser(user);
    }

    @PUT
    @Path("/{id}")
    public User updateUser(@PathParam("id") Long id, User updateUser) {
       return userService.updateUser(id, updateUser);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
    }

}
