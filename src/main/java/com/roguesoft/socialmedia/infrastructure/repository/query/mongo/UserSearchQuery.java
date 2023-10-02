package com.roguesoft.socialmedia.infrastructure.repository.query.mongo;

import com.roguesoft.socialmedia.domain.entity.search.Filter;
import com.roguesoft.socialmedia.infrastructure.repository.query.SearchQuery;

import com.roguesoft.socialmedia.infrastructure.repository.query.mongo.criteria.user.NameCriteria;
import com.roguesoft.socialmedia.infrastructure.repository.query.mongo.criteria.user.UserCriteriaBuilder;
import com.roguesoft.socialmedia.infrastructure.repository.query.mongo.criteria.user.UsernameCriteria;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class UserSearchQuery implements SearchQuery<Query> {

    @Override
    public Query buildQuery(final Filter filter) {
        UserCriteriaBuilder userCriteriaBuilder = UserCriteriaBuilder.chain(
                new NameCriteria(), new UsernameCriteria()
        );

        Query query = userCriteriaBuilder.build(filter);

        query.with(Sort.by(Sort.Direction.ASC, "name"));
        return query;
    }
}
