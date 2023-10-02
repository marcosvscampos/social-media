package com.roguesoft.socialmedia.infrastructure.repository.query.mongo.criteria.user;

import com.roguesoft.socialmedia.domain.entity.search.UserFilter;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;

import java.util.Objects;

public class UsernameCriteria extends UserCriteriaBuilder {

    public UsernameCriteria(){
        super();
    }

    @Override
    protected CriteriaDefinition buildCriteriaDefinition(UserFilter filter) {
        String username = filter.getUsername();
        if(Objects.nonNull(username) && !username.isEmpty()){
            return Criteria.where("username").is(username);
        }
        return null;
    }

}
