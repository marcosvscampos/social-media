package com.roguesoft.socialmedia.infrastructure.repository.query.mongo;

import com.roguesoft.socialmedia.domain.entity.search.Filter;
import com.roguesoft.socialmedia.domain.entity.search.UserFilter;
import com.roguesoft.socialmedia.infrastructure.repository.query.SearchQuery;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserSearchQuery implements SearchQuery<Query> {

    @Override
    public Query buildQuery(final Filter filter) {
        UserFilter userFilter = (UserFilter) filter;
        Query query = new Query();

        String name = userFilter.getName();
        if(Objects.nonNull(name) && !name.isEmpty()) {
            query.addCriteria(Criteria.where("name").regex(".*" + userFilter.getName() + ".*", "i"));
        }

        query.with(Sort.by(Sort.Direction.ASC, "name"));
        return query;
    }
}
