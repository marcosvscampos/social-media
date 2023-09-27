package com.roguesoft.socialmedia.infrastructure.repository.query;

import com.roguesoft.socialmedia.domain.entity.search.Filter;

public interface SearchQuery<T> {

     T buildQuery(final Filter filter);

}
