package com.yyit.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yyit.order.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}