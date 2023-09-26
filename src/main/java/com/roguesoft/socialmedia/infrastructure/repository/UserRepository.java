package com.roguesoft.socialmedia.infrastructure.repository;

import com.roguesoft.socialmedia.infrastructure.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    UserModel save(final UserModel model);

    Optional<UserModel> findById(final String id);

    List<UserModel> findAll();

}
