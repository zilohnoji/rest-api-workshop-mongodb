package com.donatopedro.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.donatopedro.workshopmongo.entities.Post;
import com.donatopedro.workshopmongo.repositories.PostRepository;
import com.donatopedro.workshopmongo.services.exception.ObjectNotFoundException;

@Service
@Transactional
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

}
