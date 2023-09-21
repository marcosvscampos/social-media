package com.roguesoft.socialmedia.domain.usecase;

public interface UpdateRegistryUseCase<T> {

    void execute(String id, T t);

}
