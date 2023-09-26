package com.roguesoft.socialmedia.infrastructure.repository.memory;

import com.roguesoft.socialmedia.infrastructure.model.UserModel;
import com.roguesoft.socialmedia.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public class MemoryUserRepository implements UserRepository {

    private final Map<String, UserModel> db = new HashMap<>();

    @Override
    public UserModel save(UserModel model) {
        db.put(model.getId(), model);
        return model;
    }

    @Override
    public Optional<UserModel> findById(String id) {
        UserModel model = db.get(id);
        if(Objects.nonNull(model)){
            return Optional.of(model);
        }
        return Optional.empty();
    }

    @Override
    public List<UserModel> findAll() {
        return null;
    }
}
