package com.roguesoft.socialmedia.infrastructure.repository.mongo;

import com.roguesoft.socialmedia.infrastructure.model.FriendshipModel;
import com.roguesoft.socialmedia.infrastructure.repository.FriendshipRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoFriendshipRepository extends FriendshipRepository, MongoRepository<FriendshipModel, String> {
}
