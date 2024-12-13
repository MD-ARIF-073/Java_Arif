package com.example.order_service.infradetails.persistence.adapter;

import com.example.order_service.core.domain.persistence.port.OrderPersistencePort;
import com.example.order_service.core.models.usecase.OrderDomainModel;
import com.example.order_service.infradetails.persistence.entity.OrderEntity;
import com.example.order_service.infradetails.persistence.mapper.OrderDomainEntityMapper;
import com.example.order_service.infradetails.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderPersistenceServicePortImpl implements OrderPersistencePort {

    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public OrderDomainModel getOrderById(Integer id) {
        return null;
    }

    @Override
    public Optional<OrderDomainModel> createOrder(OrderDomainModel requestBody) {

        OrderEntity orderEntityFromDB = orderRepository.save(
                OrderDomainEntityMapper
                        .INSTANCE.modelToEntity(requestBody));

        log.info("Saved entity: {}", orderEntityFromDB);
        // Convert saved entity to BezaIntegrationGatewayWriteOffInfoResponseDomainModel
        OrderDomainModel responseModel = OrderDomainEntityMapper
                .INSTANCE.entityToModel(orderEntityFromDB);

        // Publish an event to the Kafka topic "order.created"
        kafkaTemplate.send("order.created", responseModel);

        log.info("Published order.created event for order ID: {}", responseModel);

        return Optional.ofNullable(responseModel);
//        order.setStatus("CREATED");
//        OrderDomainModel savedOrder;
//        savedOrder = orderRepository.save(order);
//
//        // Publish event to Kafka
//        kafkaTemplate.send("order.created", new OrderDomainModel(
//                savedOrder.getId(),
//                savedOrder.getProductId(),
//                savedOrder.getQuantity()
//        ));
//
//        return savedOrder;
    }

}
