package com.et.ecommerce.service;

import com.et.ecommerce.entity.ConfirmationToken;
import com.et.ecommerce.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ConfirmationTokenImpl implements ConfirmationTokenService {

  private ConfirmationTokenRepository confirmationTokenRepository;
  @Override
  public ConfirmationToken create(ConfirmationToken confirmationToken) {
    return confirmationTokenRepository.save(confirmationToken);
  }
}
