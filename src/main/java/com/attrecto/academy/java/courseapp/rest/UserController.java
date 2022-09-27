package com.attrecto.academy.java.courseapp.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.attrecto.academy.java.courseapp.model.dto.CreateMinimalUserDto;
import com.attrecto.academy.java.courseapp.model.dto.MinimalUserDto;
import com.attrecto.academy.java.courseapp.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users API")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "List all Users", security = { @SecurityRequirement(name = "token") })
	public List<MinimalUserDto> getAllCourse() {
		return userService.listAllUsers();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Get a user by id", security = { @SecurityRequirement(name = "token") })
	public MinimalUserDto getCourseById(@PathVariable final Integer id) {
		return userService.getUserById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Create a new user", security = { @SecurityRequirement(name = "token") })
	public MinimalUserDto createUser(@Valid @RequestBody CreateMinimalUserDto createMinimalUserDto) {
		return userService.createUser(createMinimalUserDto);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Updating an existing user", security = { @SecurityRequirement(name = "token") })
	public MinimalUserDto updateUser(
			@PathVariable final Integer id,
			@Valid @RequestBody CreateMinimalUserDto createMinimalUserDto) {
		return userService.updateCourse(id, createMinimalUserDto);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Delete an existing user", security = { @SecurityRequirement(name = "token") })
	public void deleteUser(@PathVariable final Integer id) {
		userService.deleteUser(id);
	}
}
