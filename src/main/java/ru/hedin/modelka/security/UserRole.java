package ru.hedin.modelka.security;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_GM;

    @Override
    public String getAuthority() {

        return toString();
    }
}
