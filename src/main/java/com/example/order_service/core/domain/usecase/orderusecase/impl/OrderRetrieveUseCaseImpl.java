package com.example.order_service.core.domain.usecase.orderusecase.impl;

import com.example.order_service.core.constant.HttpStatusCode;
import com.example.order_service.core.domain.persistence.port.OrderPersistencePort;
import com.example.order_service.core.domain.usecase.orderusecase.OrderRetrieveUseCase;
import com.example.order_service.core.models.usecase.OrderDomainModel;
import com.example.order_service.core.shared.exceptions.DataNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderRetrieveUseCaseImpl implements OrderRetrieveUseCase {

    private final OrderPersistencePort orderPersistencePort;

    @Override
    public OrderDomainModel getOrderById(Integer id) throws DataNotFoundException {

        OrderDomainModel foundOrder = orderPersistencePort.getOrderById(id);

        if (foundOrder == null) {
            throw new DataNotFoundException("Order Not Found", HttpStatusCode.NOT_FOUND);
        }
        return foundOrder;
    }

}
