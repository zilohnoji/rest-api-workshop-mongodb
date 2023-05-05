package com.donatopedro.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.donatopedro.workshopmongo.dto.UserDTO;
import com.donatopedro.workshopmongo.entities.User;
import com.donatopedro.workshopmongo.repositories.UserRepository;
import com.donatopedro.workshopmongo.services.exception.ObjectNotFoundException;

@Service
@Transactional
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

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User fromDTO(UserDTO dto) {
		return new User(dto.getName(), dto.getId(), dto.getEmail());
	}

	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		return repo.save(newUser);
	}

	public void updateData(User newUser, User user) {
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());

	}
}
