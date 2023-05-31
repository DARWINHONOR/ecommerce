package com.et.ecommerce.controller;

import com.et.ecommerce.dto.ErrorResponseDto;
import com.et.ecommerce.dto.RoleDto;
import com.et.ecommerce.entity.Role;
import com.et.ecommerce.service.RoleService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/roles")
@Slf4j
public class RoleController {

  private RoleService roleService;
  @GetMapping("/name/{name}")
  public ResponseEntity<Role> getByName(@PathVariable String name){
    RoleController.log.info("NAME {} " , name);
    Role roleFound = roleService.getByName(name);
    return ResponseEntity.status(HttpStatus.OK).body(roleFound);
  }

  @GetMapping
  public ResponseEntity<List<Role>> getAll(){
    List<Role> roles = roleService.getAll();
    return ResponseEntity.ok(roles);
  }

  @PostMapping
  public ResponseEntity<Role> create(@RequestBody RoleDto dto){
    Role role = roleService.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(role);
  }
}
