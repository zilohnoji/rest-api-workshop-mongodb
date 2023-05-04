package com.donatopedro.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donatopedro.workshopmongo.entities.User;
import com.donatopedro.workshopmongo.entities.UserBan;
import com.donatopedro.workshopmongo.repositories.UserBanRepository;
import com.donatopedro.workshopmongo.repositories.UserRepository;
import com.donatopedro.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private UserBanRepository repoBan;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	public void banUserByEmail(User user) {
		repoBan.save(new UserBan(user));
	}
}
