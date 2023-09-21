package com.roguesoft.socialmedia.domain.ports;

import java.util.List;

public interface DatabasePort<T> {

    String create(T t);

    T findById(String id);

    List<T> findAll();

}
