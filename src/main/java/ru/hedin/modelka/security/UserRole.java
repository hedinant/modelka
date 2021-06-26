package ru.hedin.modelka.security;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    FirstRole,
    SecondRole;

    @Override
    public String getAuthority() {
        return toString();
    }
}
