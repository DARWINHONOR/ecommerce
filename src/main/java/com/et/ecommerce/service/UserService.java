package com.et.ecommerce.service;

import com.et.ecommerce.dto.UserDto;
import com.et.ecommerce.entity.User;
import java.util.List;
import java.util.UUID;

public interface UserService {
  UserDto getById(UUID ID);
  List<User> getAll();

  User create(User user);
  boolean existEmail(String email);
}
