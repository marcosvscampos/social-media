package com.roguesoft.socialmedia.infrastructure.repository;

import com.roguesoft.socialmedia.domain.entity.search.Filter;
import com.roguesoft.socialmedia.infrastructure.model.UserModel;

import java.util.List;

public interface UserQueryRepository {

    List<UserModel> findAllByFilters(Filter filter);

}
