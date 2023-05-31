package com.et.ecommerce.controller;

import com.et.ecommerce.dto.UserDto;
import com.et.ecommerce.entity.Category;
import com.et.ecommerce.entity.User;
import com.et.ecommerce.service.UserService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

  private UserService userService;
  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getById(@PathVariable UUID id){
    return ResponseEntity.ok(userService.getById(id));
  }

  @GetMapping
  public ResponseEntity<List<User>> getAll(){
    List<User> users = userService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(users);
  }
}
