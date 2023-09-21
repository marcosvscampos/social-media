package com.roguesoft.socialmedia.infrastructure.repository.mongo;

import com.roguesoft.socialmedia.infrastructure.model.UserModel;
import com.roguesoft.socialmedia.infrastructure.repository.UserRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoUserRepository extends UserRepository, MongoRepository<UserModel, String> {
}
