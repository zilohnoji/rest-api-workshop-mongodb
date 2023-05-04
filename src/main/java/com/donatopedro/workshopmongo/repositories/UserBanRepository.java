package com.donatopedro.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.donatopedro.workshopmongo.entities.UserBan;

public interface UserBanRepository extends MongoRepository<UserBan, String> {

}
