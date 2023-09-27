package com.roguesoft.socialmedia.infrastructure.data;

import com.roguesoft.socialmedia.domain.entity.User;
import com.roguesoft.socialmedia.domain.entity.search.Filter;
import com.roguesoft.socialmedia.domain.entity.search.UserFilter;
import com.roguesoft.socialmedia.domain.ports.DatabasePort;
import com.roguesoft.socialmedia.infrastructure.mapper.DataMapper;
import com.roguesoft.socialmedia.infrastructure.model.UserModel;
import com.roguesoft.socialmedia.infrastructure.repository.UserQueryRepository;
import com.roguesoft.socialmedia.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDataAdapter implements DatabasePort<User> {

    @Qualifier("mongoUserRepository")
    private final UserRepository repository;

    private final UserQueryRepository queryRepository;

    private final DataMapper<User, UserModel> dataMapper;

    public String create(final User user){
        UserModel savedModel = repository.save(dataMapper.toModel(user));
        return savedModel.getId();
    }

    @Override
    public User findById(final String id) {
        UserModel model = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
        return dataMapper.toEntity(model);
    }

    @Override
    public List<User> findAllByFilters(final Filter filter) {
        return queryRepository.findAllByFilters(filter).stream()
                .map(dataMapper::toEntity).toList();
    }

}
