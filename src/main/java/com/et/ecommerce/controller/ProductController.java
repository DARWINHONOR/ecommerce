package com.et.ecommerce.controller;

import com.et.ecommerce.dto.PageDto;
import com.et.ecommerce.dto.ProductDto;
import com.et.ecommerce.entity.Category;
import com.et.ecommerce.entity.Product;
import com.et.ecommerce.service.ProductService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

  private ProductService productService;

  @GetMapping("/{id}")
  public ResponseEntity<Product> getById (@PathVariable UUID id){
    Product productFound = productService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(productFound);
  }
  @PostMapping
  public ResponseEntity<Product> create(@RequestBody ProductDto dto){
    Product productSaved = productService.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
  }

  @GetMapping("/pageable")
  public ResponseEntity<Page<Product>> getProducts(@RequestParam int page, @RequestParam int size){
    Pageable pageable = PageRequest.of(page,size);
    Page<Product> productPage = productService.getProducts(pageable);
    return ResponseEntity.status(HttpStatus.OK).body(productPage);
  }

  @GetMapping("/")
  public ResponseEntity<PageDto<Product>> getFilteredProducts(
      @RequestParam Double minPrice,
      @RequestParam Double maxPrice,
      @RequestParam int page,
      @RequestParam int size,
      @RequestParam String sortField,
      @RequestParam String sortOrder
  ){
    Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
    Pageable pageable = PageRequest.of(page, size, sort);
    PageDto<Product> productPage = productService.getFilteredProducts(minPrice, maxPrice, pageable);
    return ResponseEntity.status(HttpStatus.OK).body(productPage);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> update(@PathVariable UUID id, @RequestBody ProductDto dto){
    Product productUpdated = productService.update(id, dto);
    return ResponseEntity.status(HttpStatus.OK).body(productUpdated);
  }

  @GetMapping("/category/{categoryId}")
  public ResponseEntity<PageDto<Product>> getProducts(@PathVariable UUID categoryId, @RequestParam int page, @RequestParam int size){
    Pageable pageable = PageRequest.of(page,size);
    PageDto<Product> productPage = productService.getProductsByCategory(categoryId, pageable);
    return ResponseEntity.status(HttpStatus.OK).body(productPage);
  }
}
