package com.et.ecommerce.dto;

import com.et.ecommerce.entity.Role;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationRequestDto {

  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String address;
}
