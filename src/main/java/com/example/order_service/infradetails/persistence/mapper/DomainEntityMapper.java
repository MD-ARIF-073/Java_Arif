package com.example.order_service.infradetails.persistence.mapper;

import java.util.List;

public interface DomainEntityMapper<T, S> {

    T entityToModel(S entity);

    S modelToEntity(T model);

    List<T> entityToModel(List<S> entities);

    List<S> modelToEntity(List<T> models);

}
