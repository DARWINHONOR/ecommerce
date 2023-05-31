package com.et.ecommerce.service;

import com.et.ecommerce.entity.Category;
import com.et.ecommerce.exception.EntityNotFoundException;
import com.et.ecommerce.repository.CategoryRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

  private CategoryRepository categoryRepository;
  @Override
  public Category getById(UUID id) {
    return categoryRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("Category", id));
  }

  @Override
  public List<Category> getAll() {
    return categoryRepository.findAll();
  }
}
