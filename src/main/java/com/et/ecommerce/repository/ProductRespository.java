package com.et.ecommerce.repository;

import com.et.ecommerce.entity.Product;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRespository extends JpaRepository<Product, UUID> {
  Page<Product> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);
  Page<Product> findByCategoryId(UUID categoryId, Pageable pageable);
}
