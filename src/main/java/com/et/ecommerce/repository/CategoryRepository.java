package com.et.ecommerce.repository;

import com.et.ecommerce.entity.Category;
import com.et.ecommerce.entity.Product;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
