package com.roguesoft.socialmedia.domain.usecase;

public interface GetRegistryUseCase<String, T> {

    T execute(final String id);

}
