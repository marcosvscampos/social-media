package com.roguesoft.socialmedia.infrastructure.repository.memory;

import com.roguesoft.socialmedia.infrastructure.model.FriendshipModel;
import com.roguesoft.socialmedia.infrastructure.repository.FriendshipRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public class MemoryFriendshipRepository implements FriendshipRepository {

    private final Map<String, FriendshipModel> db = new HashMap<>();

    @Override
    public FriendshipModel save(FriendshipModel model) {
        db.put(model.getId(), model);
        return model;
    }

    @Override
    public Optional<FriendshipModel> findById(String id) {
        FriendshipModel model = db.get(id);
        if(Objects.nonNull(model)){
            return Optional.of(model);
        }
        return Optional.empty();
    }

    @Override
    public List<FriendshipModel> findByUserId(String userId) {
        return null;
    }
}
