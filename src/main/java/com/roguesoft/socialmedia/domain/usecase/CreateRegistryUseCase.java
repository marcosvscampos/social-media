package com.roguesoft.socialmedia.domain.usecase;

public interface CreateRegistryUseCase<T, X> {

    X execute(T t);

}
