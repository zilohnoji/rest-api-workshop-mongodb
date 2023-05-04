package com.donatopedro.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.donatopedro.workshopmongo.entities.User;
import com.donatopedro.workshopmongo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
}
