package com.et.ecommerce.service;

import com.et.ecommerce.dto.PageDto;
import com.et.ecommerce.dto.ProductDto;
import com.et.ecommerce.entity.Category;
import com.et.ecommerce.entity.Product;
import com.et.ecommerce.exception.EntityNotFoundException;
import com.et.ecommerce.mapper.ProductMapper;
import com.et.ecommerce.repository.ProductRespository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

  private ProductRespository productRespository;
  private CategoryService categoryService;
  private ProductMapper productMapper;

  @Override
  public Product getById(UUID id) {
    return productRespository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product", id));
  }

  @Override
  public Product create(ProductDto dto) {
    Category category = categoryService.getById(dto.getCategoryId());
    Product product = productMapper.fromDto(dto);
    product.setCategory(category);
    return productRespository.save(product);

  }

  @Override
  public Page<Product> getProducts(Pageable pageable) {
    return productRespository.findAll(pageable);
  }

  @Override
  public PageDto<Product> getFilteredProducts(Double minPrice, Double maxPrice, Pageable pageable) {
    Page<Product> page = productRespository.findByPriceBetween(minPrice, maxPrice, pageable);
    return productMapper.fromEntity(page);
  }

  @Override
  public Product update(UUID id, ProductDto dto) {
    Product productFound = productRespository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product", id));
    Product productMap = productMapper.fromDtoUpdate(dto, productFound);
    productMap.setCategory(categoryService.getById(dto.getCategoryId()));
    return productRespository.save(productFound);
  }

  @Override
  public PageDto<Product> getProductsByCategory(UUID categoryId, Pageable pageable) {
    Page<Product> page = productRespository.findByCategoryId(categoryId, pageable);
    return productMapper.fromEntity(page);
  }

}
