package com.donatopedro.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.donatopedro.workshopmongo.entities.Post;
import com.donatopedro.workshopmongo.services.PostService;

@RestController
@RequestMapping("/post")
public class UserResource {

	@Autowired
	PostService service;

	@GetMapping(path = "/find-id")
	public @ResponseBody ResponseEntity<Post> findById(@RequestParam(name = "id") String id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

}
