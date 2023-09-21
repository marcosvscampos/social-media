package com.roguesoft.socialmedia.domain.usecase.impl.user;

import com.roguesoft.socialmedia.application.dto.user.UserDTO;
import com.roguesoft.socialmedia.domain.entity.User;
import com.roguesoft.socialmedia.domain.mapper.DomainMapper;
import com.roguesoft.socialmedia.domain.ports.DatabasePort;
import com.roguesoft.socialmedia.domain.usecase.GetRegistryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserByIdUseCase implements GetRegistryUseCase<String, UserDTO> {

    private final DatabasePort<User> databasePort;
    private final DomainMapper<UserDTO, User> domainMapper;

    @Override
    public UserDTO execute(String id) {
        return domainMapper.toResponse(databasePort.findById(id));
    }
}
