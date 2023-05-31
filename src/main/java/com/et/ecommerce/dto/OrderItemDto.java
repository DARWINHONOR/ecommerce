package com.et.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemDto {
  private Integer quantity;
  private UUID productId;
  @JsonProperty(access = Access.READ_ONLY)
  private Double totalPrice;

  public OrderItemDto(UUID productId, Integer quantity, Double totalPrice) {
    this.quantity = quantity;
    this.productId = productId;
    this.totalPrice = totalPrice;
  }
}
