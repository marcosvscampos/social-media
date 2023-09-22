package com.roguesoft.socialmedia.domain.usecase.impl.friends;

import com.roguesoft.socialmedia.application.dto.user.UserDTO;
import com.roguesoft.socialmedia.domain.entity.Friendship;
import com.roguesoft.socialmedia.domain.entity.User;
import com.roguesoft.socialmedia.domain.entity.search.Filter;
import com.roguesoft.socialmedia.domain.mapper.DomainMapper;
import com.roguesoft.socialmedia.domain.ports.DatabasePort;
import com.roguesoft.socialmedia.domain.usecase.GetAllRegistryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetUserFriendsUseCase implements GetAllRegistryUseCase<UserDTO> {

    private final DatabasePort<Friendship> friendshipDatabasePort;
    private final DatabasePort<User> userDatabasePort;

    private final DomainMapper<UserDTO, User> userDomainMapper;

    @Override
    public List<UserDTO> execute(final Filter filter) {
        List<Friendship> friends = friendshipDatabasePort.findAllByFilters(filter);
        List<User> userFriends = friends.stream().map(f -> userDatabasePort.findById(f.getFriendId())).toList();
        return userFriends.stream().map(userDomainMapper::toResponse).toList();
    }
}
