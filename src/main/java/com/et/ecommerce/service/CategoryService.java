package com.et.ecommerce.service;

import com.et.ecommerce.entity.Category;
import java.util.List;
import java.util.UUID;

public interface CategoryService {
  Category getById(UUID id);
  List<Category> getAll();
}
