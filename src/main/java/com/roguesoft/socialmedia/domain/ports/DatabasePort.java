package com.roguesoft.socialmedia.domain.ports;

import com.roguesoft.socialmedia.domain.entity.search.Filter;

import java.util.List;

public interface DatabasePort<T> {

    String create(T t);

    T findById(String id);

    List<T> findAllByFilters(Filter filter);

}
