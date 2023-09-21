package com.roguesoft.socialmedia.infrastructure.mapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Getter
@RequiredArgsConstructor
public abstract class DataMapper<E, M> {

    private final ModelMapper mapper;

    public abstract M toModel(E e);

    public abstract E toEntity(M m);
}
