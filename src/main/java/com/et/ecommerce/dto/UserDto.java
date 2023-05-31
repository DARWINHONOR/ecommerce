package com.et.ecommerce.dto;

import com.et.ecommerce.entity.Role;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
  private UUID id;
  private String firstName;
  private String lastName;
  private String email;
  private String address;
  private String roleName;
}
