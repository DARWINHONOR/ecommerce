package com.et.ecommerce.service;

import com.et.ecommerce.dto.PageDto;
import com.et.ecommerce.dto.ProductDto;
import com.et.ecommerce.entity.Product;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
  Product getById(UUID id);
  Product create(ProductDto product);
  Page<Product> getProducts(Pageable pageable);
  PageDto<Product> getFilteredProducts(Double minPrice, Double maxPrice, Pageable pageable);
  Product update(UUID id, ProductDto dto);
  PageDto<Product> getProductsByCategory(UUID categoryId, Pageable pageable);
}
