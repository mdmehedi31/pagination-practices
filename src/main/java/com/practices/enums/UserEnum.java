package com.practices.enums;

public enum UserEnum {

    Id("id"),
    USERNAME("username"),
    EMAIL("email"),
    PHONE("phone"),
    AGE("age"),
    GENDER("gender"),
    USERADDRESS("user_address"),
    ;


    private final String dbColumnName;


    UserEnum(String dbColumnName) {
        this.dbColumnName = dbColumnName;
    }
}
