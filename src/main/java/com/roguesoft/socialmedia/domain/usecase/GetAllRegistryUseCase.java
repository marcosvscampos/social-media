package com.roguesoft.socialmedia.domain.usecase;

import com.roguesoft.socialmedia.domain.entity.search.Filter;

import java.util.List;

public interface GetAllRegistryUseCase<T> {

    List<T> execute(final Filter filter);

}
