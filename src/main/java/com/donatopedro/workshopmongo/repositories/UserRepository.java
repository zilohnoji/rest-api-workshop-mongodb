package com.donatopedro.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.donatopedro.workshopmongo.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
