package com.roguesoft.socialmedia.infrastructure.repository.mongo.query;

import com.roguesoft.socialmedia.domain.entity.search.Filter;
import com.roguesoft.socialmedia.infrastructure.model.UserModel;
import com.roguesoft.socialmedia.infrastructure.repository.UserQueryRepository;
import com.roguesoft.socialmedia.infrastructure.repository.query.SearchQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MongoUserQueryRepository implements UserQueryRepository {

    public final MongoTemplate mongoTemplate;

    public final SearchQuery<Query> searchQuery;

    @Override
    public List<UserModel> findAllByFilters(Filter filter) {
        return mongoTemplate.find(searchQuery.buildQuery(filter), UserModel.class);
    }

}
