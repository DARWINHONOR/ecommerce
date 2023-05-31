package com.et.ecommerce.exception;

public class EmailAlreadyTaken extends RuntimeException{

  private static final String ERROR_MESSAGE = "Email %s is alreay taken";
  public EmailAlreadyTaken(String email) {
    super(String.format(ERROR_MESSAGE, email));
  }
}
