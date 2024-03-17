package com.argoden.genesis.converter;

import java.util.List;
import java.util.stream.Collectors;

abstract public class BaseConverter<E, T> {

    public abstract T toDto(E entity);

    public abstract E toEntity(T dto);

    public List<T> toDtoCollection(List<E> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<E> toEntityCollection(List<T> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
