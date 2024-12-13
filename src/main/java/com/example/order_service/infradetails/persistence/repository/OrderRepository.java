package com.example.order_service.infradetails.persistence.repository;

import com.example.order_service.infradetails.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
