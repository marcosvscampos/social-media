package com.roguesoft.socialmedia.domain.mapper;

import com.roguesoft.socialmedia.application.dto.ResponseDTO;
import com.roguesoft.socialmedia.application.dto.friend.FriendshipDTO;
import com.roguesoft.socialmedia.domain.entity.Friendship;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FriendshipDomainMapper extends DomainMapper<FriendshipDTO, Friendship> {

    public FriendshipDomainMapper(final ModelMapper mapper) {
        super(mapper);
    }

    @Override
    public Friendship toEntity(FriendshipDTO request) {
        return super.getMapper().map(request, Friendship.class);
    }

    @Override
    public FriendshipDTO toResponse(Friendship friendship) {
        return null;
    }

    @Override
    public ResponseDTO toResponseURI(String contextPath, String id) {
        return ResponseDTO.builder()
                .uri(contextPath + "/users/" + id + "/friends")
                .build();
    }
}
