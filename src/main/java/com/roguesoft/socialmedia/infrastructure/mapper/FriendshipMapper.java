package com.roguesoft.socialmedia.infrastructure.mapper;

import com.roguesoft.socialmedia.domain.entity.Friendship;
import com.roguesoft.socialmedia.infrastructure.model.FriendshipModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FriendshipMapper extends DataMapper<Friendship, FriendshipModel> {

    public FriendshipMapper(final ModelMapper mapper) {
        super(mapper);
    }

    @Override
    public FriendshipModel toModel(final Friendship entity){
        return super.getMapper().map(entity, FriendshipModel.class);
    }

    @Override
    public Friendship toEntity(final FriendshipModel model){
        return super.getMapper().map(model, Friendship.class);
    }

}
