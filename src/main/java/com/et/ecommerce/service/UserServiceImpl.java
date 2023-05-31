package com.et.ecommerce.service;

import com.et.ecommerce.dto.UserDto;
import com.et.ecommerce.entity.User;
import com.et.ecommerce.exception.EntityNotFoundException;
import com.et.ecommerce.mapper.UserMapper;
import com.et.ecommerce.repository.UserRepositoty;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

  private UserRepositoty userRepositoty;
  private UserMapper userMapper;
  @Override
  public UserDto getById(UUID id) {
    User userFound = userRepositoty.findById(id).orElseThrow(() -> new EntityNotFoundException("User",id));
    return userMapper.fromEntity(userFound);
  }

  @Override
  public List<User> getAll() {
    return userRepositoty.findAll();
  }

  @Override
  public User create(User user) {
    return userRepositoty.save(user);
  }

  @Override
  public boolean existEmail(String email) {
    return userRepositoty.findByEmail(email).isPresent();//si encuentra devuelve true
  }
}
