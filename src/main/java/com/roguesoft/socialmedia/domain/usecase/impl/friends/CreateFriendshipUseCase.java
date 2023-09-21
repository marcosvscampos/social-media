package com.roguesoft.socialmedia.domain.usecase.impl.friends;

import com.roguesoft.socialmedia.application.dto.ResponseDTO;
import com.roguesoft.socialmedia.application.dto.friend.FriendshipDTO;
import com.roguesoft.socialmedia.domain.entity.Friendship;
import com.roguesoft.socialmedia.domain.entity.User;
import com.roguesoft.socialmedia.domain.mapper.DomainMapper;
import com.roguesoft.socialmedia.domain.ports.DatabasePort;
import com.roguesoft.socialmedia.domain.usecase.CreateRegistryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateFriendshipUseCase implements CreateRegistryUseCase<FriendshipDTO, ResponseDTO> {

    private final DatabasePort<Friendship> friendshipDatabasePort;
    private final DatabasePort<User> userDatabasePort;

    private final DomainMapper<FriendshipDTO, Friendship> domainMapper;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Override
    public ResponseDTO execute(FriendshipDTO request) {
        User user = userDatabasePort.findById(request.getUserId());
        friendshipDatabasePort.create(domainMapper.toEntity(request));
        return domainMapper.toResponseURI(contextPath, user.getId());
    }
}
