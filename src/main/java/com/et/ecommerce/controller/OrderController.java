package com.et.ecommerce.controller;

import com.et.ecommerce.dto.OrderDto;
import com.et.ecommerce.service.OrderService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
@Controller
public class OrderController {
  private OrderService orderService;

  @PostMapping
  public ResponseEntity<String> create(@RequestBody OrderDto order){
    String message = orderService.create(order);
    return ResponseEntity.status(HttpStatus.OK).body(message);
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderDto> getById(@PathVariable UUID id){
    OrderDto orderDto = orderService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(orderDto);
  }
}
