package com.yaagoub.misanuncios.domain.errors;


public enum ErrorsEnum {

  PET_NOT_FOUND("1", "The pet was not found");


  private String code;

  private String description;

  ErrorsEnum(String code, String description) {

    this.code = code;
    this.description = description;
  }

  @Override
  public String toString() {
    return String.valueOf(description);
  }

  public static ErrorsEnum fromValue(String text) {
    for (ErrorsEnum b : ErrorsEnum.values()) {
      if (String.valueOf(b.code).equals(text)) {
        return b;
      }
    }
    return null;
  }
}



