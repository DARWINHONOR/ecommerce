package com.et.ecommerce.mapper;

import com.et.ecommerce.dto.RoleDto;
import com.et.ecommerce.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
  public Role fromDto(RoleDto dto){
    Role role = new Role();
    role.setName(dto.getName());
    role.setDescription(dto.getDescription());

    return role;
  }
}
