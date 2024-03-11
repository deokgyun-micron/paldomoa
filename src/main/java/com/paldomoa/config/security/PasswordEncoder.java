package com.paldomoa.config.security;

public interface PasswordEncoder {
    String encode(String password);

    boolean matches(String password, String hashed);
}
