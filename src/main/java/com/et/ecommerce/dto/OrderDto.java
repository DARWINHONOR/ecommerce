package com.et.ecommerce.dto;

import com.et.ecommerce.entity.OrderState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
  private String comment;
  private List<OrderItemDto> items;

  @JsonProperty(access = Access.READ_ONLY)
  private Double totalPrice;
  @JsonProperty(access = Access.READ_ONLY)
  private OrderState state;
}
