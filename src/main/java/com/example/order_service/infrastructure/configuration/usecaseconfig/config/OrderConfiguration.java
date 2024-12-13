package com.example.order_service.infrastructure.configuration.usecaseconfig.config;

import com.example.order_service.core.domain.persistence.port.OrderPersistencePort;
import com.example.order_service.core.domain.usecase.orderusecase.OrderModificationUseCase;
import com.example.order_service.core.domain.usecase.orderusecase.OrderRetrieveUseCase;
import com.example.order_service.core.domain.usecase.orderusecase.impl.OrderModificationUseCaseImpl;
import com.example.order_service.core.domain.usecase.orderusecase.impl.OrderRetrieveUseCaseImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class OrderConfiguration {

    private final OrderPersistencePort orderPersistencePort;

    @Bean
    public OrderRetrieveUseCase orderRetrieveUseCase() {
        return new OrderRetrieveUseCaseImpl(orderPersistencePort);
    }

    @Bean
    public OrderModificationUseCase orderModificationUseCase() {
        return new OrderModificationUseCaseImpl(orderPersistencePort);
    }

}
