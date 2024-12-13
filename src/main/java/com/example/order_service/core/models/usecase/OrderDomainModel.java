package com.example.order_service.core.models.usecase;

import com.example.order_service.core.models.BaseDomainModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDomainModel extends BaseDomainModel {

    private Long orderId;
    private String productId;
    private int quantity;
    private String status;

}
