package com.et.ecommerce.exception;
public class RoleAlreadyExists extends RuntimeException{

  private static final String ERROR_MESSAGE = "Role with name %s already exists";
  private static final String ERROR_NAME = "Role Name Already Exists";
  public RoleAlreadyExists(String role) {
    super(String.format(ERROR_MESSAGE, role));
  }

  @Override
  public String toString() {
    return ERROR_NAME;
  }
}
