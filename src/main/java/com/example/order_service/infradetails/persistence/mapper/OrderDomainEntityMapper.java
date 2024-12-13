package com.example.order_service.infradetails.persistence.mapper;

import com.example.order_service.core.models.usecase.OrderDomainModel;
import com.example.order_service.infradetails.persistence.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDomainEntityMapper extends DomainEntityMapper<OrderDomainModel, OrderEntity> {

    OrderDomainEntityMapper INSTANCE = Mappers.getMapper(OrderDomainEntityMapper.class);

}
