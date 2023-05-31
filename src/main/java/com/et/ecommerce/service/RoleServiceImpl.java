package com.et.ecommerce.service;

import com.et.ecommerce.dto.RoleDto;
import com.et.ecommerce.entity.Role;
import com.et.ecommerce.exception.EmailAlreadyTaken;
import com.et.ecommerce.exception.RoleAlreadyExists;
import com.et.ecommerce.mapper.RoleMapper;
import com.et.ecommerce.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService{

  private RoleRepository roleRepository;
  private RoleMapper roleMapper;
  @Override
  public Role getByName(String name) {
    return roleRepository.findByName(name).orElseThrow(()->new EntityNotFoundException("Role not found"));
  }

  @Override
  public List<Role> getAll() {
    return roleRepository.findAll();
  }

  @Override
  public Role create(RoleDto dto) {

    if(existRole(dto.getName())){
      throw new RoleAlreadyExists(dto.getName());
    }

    return roleRepository.save(roleMapper.fromDto(dto));
  }

  public boolean existRole(String name) {
    return roleRepository.findByName(name).isPresent();//si encuentra devuelve true
  }
}
