package com.roguesoft.socialmedia.infrastructure.repository.query.mongo.criteria.user;

import com.roguesoft.socialmedia.domain.entity.search.Filter;
import com.roguesoft.socialmedia.domain.entity.search.UserFilter;
import lombok.Getter;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Objects;

public abstract class UserCriteriaBuilder {

    private UserCriteriaBuilder next;

    @Getter
    private Query query;

    public static UserCriteriaBuilder chain(UserCriteriaBuilder first, UserCriteriaBuilder... chain){
        UserCriteriaBuilder head = first;
        for (UserCriteriaBuilder nextInChain: chain){
            head.query = nextInChain.query;
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public UserCriteriaBuilder() {
        query = new Query();
    }

    public Query build(Filter filter){
        UserFilter userFilter = (UserFilter) filter;
        CriteriaDefinition cd = buildCriteriaDefinition(userFilter);

        if(Objects.nonNull(cd)){
            this.query.addCriteria(cd);
        }

        if(Objects.nonNull(this.next)){
            return this.next.build(userFilter);
        }

        return this.query;
    }

    protected abstract CriteriaDefinition buildCriteriaDefinition(UserFilter filter);
}
