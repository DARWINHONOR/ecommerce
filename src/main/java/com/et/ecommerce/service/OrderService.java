package com.et.ecommerce.service;

import com.et.ecommerce.dto.OrderDto;
import com.et.ecommerce.entity.Order;
import java.util.UUID;

public interface OrderService {
  String create(OrderDto order);
  OrderDto getById(UUID id);
}
