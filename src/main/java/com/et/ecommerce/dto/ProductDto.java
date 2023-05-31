package com.et.ecommerce.dto;

import com.et.ecommerce.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
  private String name;
  private String description;
  private String imageUrl;
  private double price;
  private int stock;
  private boolean active;
  private UUID categoryId;
}
