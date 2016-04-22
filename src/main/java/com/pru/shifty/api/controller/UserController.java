package com.pru.shifty.api.controller;

import java.util.List;

import com.pru.shifty.api.basic.RestError;
import com.pru.shifty.api.basic.RestResponse;
import com.pru.shifty.api.basic.RestResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pru.shifty.api.model.User;
import com.pru.shifty.api.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public RestResponse<List<User>> getUsers() {
        RestResponse<List<User>> response = new RestResponse<List<User>>();
		List<User> users = userService.findAllUsers();
		response.addResponse(users);
		return response;
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse<User> getUser(@PathVariable("userId") long id) {
        RestResponse<User> response = new RestResponse<User>();
		User user = userService.get(id);
		if (user == null) {
			response.addRestError(new RestError("User not found."));
		}
        response.addResponse(user);
		return response;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public RestResponse<User> createUser(@RequestBody User user) {
        RestResponse<User> response = new RestResponse<User>();
		if (userService.isUserExist(user)) {
            response.addRestError(new RestError("User already exists."));
			return response;
        }

		User createdUser = userService.create(user);
        response.addResponse(createdUser);
		return response;
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
	public RestResponse<User> updateUser(@PathVariable("userId") long id, @RequestBody User user) {
        RestResponse<User> response = new RestResponse<User>();

        User currentUser = userService.get(id);
        if (currentUser == null) {
            response.addRestError(new RestError("User not found."));
        }
        user.setId(id);
		
		userService.update(id, user);
        User updatedUser = userService.get(id);
        response.addResponse(updatedUser);
		return response;
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
	public RestResponse<User> deleteUser(@PathVariable("userId") long id) {
        RestResponse<User> response = new RestResponse<User>();
        User user = userService.get(id);
        if (user == null) {
            response.addRestError(new RestError("User not found."));
        }
		userService.delete(id);
        response.setStatus(RestResponseStatus.SUCCESS);
		return response;
	}
}
