package com.et.ecommerce.mapper;

import com.et.ecommerce.dto.UserDto;
import com.et.ecommerce.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  public UserDto fromEntity(User user){
    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setEmail(user.getEmail());
    userDto.setAddress(user.getAddress());
    userDto.setFirstName(user.getFirstName());
    userDto.setLastName(user.getLastName());
    userDto.setRoleName(user.getRole().getName());

    return userDto;
  }
}
