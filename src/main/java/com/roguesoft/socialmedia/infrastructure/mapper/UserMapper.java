package com.roguesoft.socialmedia.infrastructure.mapper;

import com.roguesoft.socialmedia.domain.entity.User;
import com.roguesoft.socialmedia.infrastructure.model.UserModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends DataMapper<User, UserModel> {

    public UserMapper(final ModelMapper mapper){
        super(mapper);
        TypeMap<User, UserModel> typeMapToModel = mapper.createTypeMap(User.class, UserModel.class);
        typeMapToModel.addMapping(User::getId, UserModel::setId);
    }

    public UserModel toModel(final User entity){
        return super.getMapper().map(entity, UserModel.class);
    }

    public User toEntity(final UserModel model){
        return super.getMapper().map(model, User.class);
    }

}
