package com.roguesoft.socialmedia.infrastructure.repository.query.mongo.criteria.user;

import com.roguesoft.socialmedia.domain.entity.search.UserFilter;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;

import java.util.Objects;

public class NameCriteria extends UserCriteriaBuilder {

    public NameCriteria(){
        super();
    }

    @Override
    protected CriteriaDefinition buildCriteriaDefinition(UserFilter filter) {
        String name = filter.getName();
        if(Objects.nonNull(name) && !name.isEmpty()) {
            return Criteria.where("name").regex(".*" + filter.getName() + ".*", "i");
        }
        return null;
    }

}
