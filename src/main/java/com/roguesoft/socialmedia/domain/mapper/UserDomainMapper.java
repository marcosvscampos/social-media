package com.roguesoft.socialmedia.domain.mapper;

import com.roguesoft.socialmedia.application.dto.ResponseDTO;
import com.roguesoft.socialmedia.application.dto.user.UserDTO;
import com.roguesoft.socialmedia.domain.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDomainMapper extends DomainMapper<UserDTO, User> {

    public UserDomainMapper(final ModelMapper mapper){
        super(mapper);
    }

    public User toEntity(final UserDTO dto){
        return super.getMapper().map(dto, User.class);
    }

    @Override
    public ResponseDTO toResponseURI(final String contextPath, final String userId) {
        return ResponseDTO.builder()
                .uri(contextPath + "/users/" + userId)
                .build();
    }

    @Override
    public UserDTO toResponse(final User entity){
        return super.getMapper().map(entity, UserDTO.class);
    }
}
