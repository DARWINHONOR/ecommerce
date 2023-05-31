package com.et.ecommerce.service;

import com.et.ecommerce.dto.OrderDto;
import com.et.ecommerce.entity.Order;
import com.et.ecommerce.entity.OrderItem;
import com.et.ecommerce.exception.EntityNotFoundException;
import com.et.ecommerce.repository.OrderRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{

  private ProductService productService;
  private OrderRepository orderRepository;
  @Override
  public String create(OrderDto dto) {
    Order order = new Order();
    order.setComment(dto.getComment());

    List<OrderItem> items = dto.getItems().stream().map((itemDto)->{
      OrderItem item = new OrderItem();
      item.setQuantity(itemDto.getQuantity());
      item.setProduct(productService.getById(itemDto.getProductId()));
      item.setOrder(order);

      return item;
    }).toList();

    order.setItems(items);
    //FALTA HACER setuser
    Order OrderSaved = orderRepository.save(order);
    return "Order saved successfully !!";
  }

  @Override
  public OrderDto getById(UUID id) {
    Order order = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order",id));

    OrderDto orderDto = new OrderDto();
    orderDto.setComment(order.getComment());
    orderDto.setState(order.getState());
    orderDto.setTotalPrice(orderRepository.getTotalPrice(id));
    orderDto.setItems(orderRepository.getItemWithTotalPrice(id));

    return orderDto;
  }
}
