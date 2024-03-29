package com.roguesoft.socialmedia.infrastructure.repository;

import com.roguesoft.socialmedia.infrastructure.model.FriendshipModel;

import java.util.List;
import java.util.Optional;

public interface FriendshipRepository {

    FriendshipModel save(final FriendshipModel model);

    Optional<FriendshipModel> findById(final String id);

    List<FriendshipModel> findByUserId(final String userId);

}
