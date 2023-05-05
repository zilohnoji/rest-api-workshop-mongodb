package com.donatopedro.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donatopedro.workshopmongo.dto.UserDTO;
import com.donatopedro.workshopmongo.entities.User;
import com.donatopedro.workshopmongo.repositories.UserRepository;
import com.donatopedro.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	public User insert(User user) {
		return repo.insert(user);
	}

	public User fromDTO(UserDTO dto) {
		return new User(dto.getName(), dto.getId(), dto.getEmail());
	}
}
