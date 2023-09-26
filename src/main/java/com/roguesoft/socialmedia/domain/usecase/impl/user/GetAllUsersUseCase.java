package com.roguesoft.socialmedia.domain.usecase.impl.user;

import com.roguesoft.socialmedia.application.dto.user.UserDTO;
import com.roguesoft.socialmedia.domain.entity.User;
import com.roguesoft.socialmedia.domain.entity.search.Filter;
import com.roguesoft.socialmedia.domain.mapper.DomainMapper;
import com.roguesoft.socialmedia.domain.ports.DatabasePort;
import com.roguesoft.socialmedia.domain.usecase.GetAllRegistryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class GetAllUsersUseCase implements GetAllRegistryUseCase<UserDTO> {

    private final DatabasePort<User> userDatabasePort;

    private final DomainMapper<UserDTO, User> userDomainMapper;

    @Override
    public List<UserDTO> execute(Filter filter) {
        List<User> users = userDatabasePort.findAllByFilters(filter);
        return users.stream().map(userDomainMapper::toResponse).toList();
    }
}
