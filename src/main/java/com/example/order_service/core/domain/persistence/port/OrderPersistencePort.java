package com.example.order_service.core.domain.persistence.port;

import com.example.order_service.core.models.usecase.OrderDomainModel;

import java.util.Optional;

public interface OrderPersistencePort {

    OrderDomainModel getOrderById(Integer id);

    Optional<OrderDomainModel> createOrder(OrderDomainModel orderDomainModel);

}
