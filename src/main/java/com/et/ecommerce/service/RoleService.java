package com.et.ecommerce.service;

import com.et.ecommerce.dto.RoleDto;
import com.et.ecommerce.entity.Role;
import java.util.List;

public interface RoleService {
  Role getByName(String name);
  List<Role> getAll();
  Role create(RoleDto role);
}
