package com.et.ecommerce.service;

import com.et.ecommerce.dto.RegistrationRequestDto;
import com.et.ecommerce.entity.ConfirmationToken;
import com.et.ecommerce.entity.User;
import com.et.ecommerce.exception.EmailAlreadyTaken;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService{

  private UserService userService;
  private RoleService roleService;
  private ConfirmationTokenService confirmationTokenService;

  @Override
  public String register(RegistrationRequestDto dto) {
    //verify email
    if(userService.existEmail(dto.getEmail())){
      throw new EmailAlreadyTaken("Email already taken");
    }

    //save user
    User user = new User();
    user.setFirstName(dto.getFirstName());
    user.setLastName(dto.getLastName());
    user.setAddress(dto.getAddress());
    user.setEmail(dto.getEmail());
    //TODO; encript password
    user.setPassword(dto.getPassword());
    user.setRole(roleService.getByName("USER"));

    userService.create(user);

    //save confirmation token
    String token = UUID.randomUUID().toString();

    ConfirmationToken confirmationToken = new ConfirmationToken(
        token,
        LocalDateTime.now(),
        LocalDateTime.now().plusMinutes(15),
        user
    );

    confirmationTokenService.create(confirmationToken);

    //TODO: Send confirmationtoken by email

    return token;
  }
}
