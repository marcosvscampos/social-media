package com.roguesoft.socialmedia.infrastructure.data;

import com.roguesoft.socialmedia.domain.entity.Friendship;
import com.roguesoft.socialmedia.domain.ports.DatabasePort;
import com.roguesoft.socialmedia.infrastructure.mapper.DataMapper;
import com.roguesoft.socialmedia.infrastructure.model.FriendshipModel;
import com.roguesoft.socialmedia.infrastructure.repository.FriendshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FriendshipDataAdapter implements DatabasePort<Friendship> {

    @Qualifier("mongoFriendshipRepository")
    private final FriendshipRepository repository;

    private final DataMapper<Friendship, FriendshipModel> dataMapper;

    @Override
    public String create(Friendship friendship) {
        FriendshipModel savedModel = repository.save(dataMapper.toModel(friendship));
        return savedModel.getId();
    }

    @Override
    public Friendship findById(String id) {
        FriendshipModel model = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friendship not found: " + id));
        return dataMapper.toEntity(model);
    }

    @Override
    public List<Friendship> findAll() {
        return null;
    }
}
