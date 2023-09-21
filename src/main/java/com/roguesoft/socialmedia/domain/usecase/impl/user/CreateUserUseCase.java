package com.roguesoft.socialmedia.domain.usecase.impl.user;

import com.roguesoft.socialmedia.application.dto.ResponseDTO;
import com.roguesoft.socialmedia.application.dto.user.UserDTO;
import com.roguesoft.socialmedia.domain.entity.User;
import com.roguesoft.socialmedia.domain.mapper.DomainMapper;
import com.roguesoft.socialmedia.domain.ports.DatabasePort;
import com.roguesoft.socialmedia.domain.usecase.CreateRegistryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase implements CreateRegistryUseCase<UserDTO, ResponseDTO> {

    private final DatabasePort<User> databasePort;
    private final DomainMapper<UserDTO, User> domainMapper;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Override
    public ResponseDTO execute(UserDTO request) {
        String userId = databasePort.create(domainMapper.toEntity(request));
        return domainMapper.toResponseURI(contextPath, userId);
    }
}
