package com.paldomoa.domain;

public enum RoleType {

    ROLE_USER,
    ROLE_ADMIN;

    public static RoleType from(String name) {
        return valueOf(name.toUpperCase());
    }

}
