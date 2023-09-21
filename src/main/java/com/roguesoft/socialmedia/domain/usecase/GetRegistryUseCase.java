package com.roguesoft.socialmedia.domain.usecase;

import java.util.List;

public interface GetRegistryUseCase<String, T> {

    T execute(final String id);

}
