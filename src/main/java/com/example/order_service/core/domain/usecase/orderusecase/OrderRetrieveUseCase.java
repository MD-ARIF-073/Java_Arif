package com.example.order_service.core.domain.usecase.orderusecase;

import com.example.order_service.core.models.usecase.OrderDomainModel;
import com.example.order_service.core.shared.exceptions.DataNotFoundException;

public interface OrderRetrieveUseCase {

    OrderDomainModel getOrderById(Integer id) throws DataNotFoundException;

}
