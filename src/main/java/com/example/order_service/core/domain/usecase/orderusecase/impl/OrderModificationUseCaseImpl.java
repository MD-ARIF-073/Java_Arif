package com.example.order_service.core.domain.usecase.orderusecase.impl;

import com.example.order_service.core.constant.HttpStatusCode;
import com.example.order_service.core.domain.persistence.port.OrderPersistencePort;
import com.example.order_service.core.domain.usecase.orderusecase.OrderModificationUseCase;
import com.example.order_service.core.models.usecase.OrderDomainModel;
import com.example.order_service.core.shared.exceptions.DataNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderModificationUseCaseImpl implements OrderModificationUseCase {

    private final OrderPersistencePort orderPersistencePort;

    @Override
    public OrderDomainModel createOrder(OrderDomainModel orderDomainModel) throws DataNotFoundException {
        OrderDomainModel newlyCreatedOrder = orderPersistencePort.createOrder(orderDomainModel);

        if(orderDomainModel == null)
            throw new DataNotFoundException("Order can not be created", HttpStatusCode.NOT_FOUND);

        return newlyCreatedOrder;
    }

}
