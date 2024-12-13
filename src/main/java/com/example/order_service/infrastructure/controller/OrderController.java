package com.example.order_service.infrastructure.controller;


import com.example.order_service.core.domain.usecase.orderusecase.OrderModificationUseCase;
import com.example.order_service.core.domain.usecase.orderusecase.OrderRetrieveUseCase;
import com.example.order_service.core.models.usecase.OrderDomainModel;
import com.example.order_service.infrastructure.response.builder.ResponseEntityBuilder;
import com.example.order_service.infrastructure.shared.constants.RestConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order-service/api/v1/private/orders")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final String controllerUrl = RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.API_ACCESS;

    private final OrderRetrieveUseCase orderRetrieveUseCase;
    private final OrderModificationUseCase orderModificationUseCase;
    private final ResponseEntityBuilder responseEntityBuilder;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDomainModel> save(@RequestBody OrderDomainModel orderDomainModel) {
        log.info("calling POST " + controllerUrl + "/orders to save port info");
        log.info("request body: " + orderDomainModel);
        OrderDomainModel response = orderModificationUseCase.createOrder(orderDomainModel);
        return responseEntityBuilder.buildOkListResponse(response);
    }


    @GetMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDomainModel> getById(@PathVariable Long id) {
        OrderDomainModel res = orderRetrieveUseCase.getOrderById(Math.toIntExact(id));

        ResponseEntity<OrderDomainModel> response = responseEntityBuilder
                .buildOkListResponse(res);

        return response;
    }

}
