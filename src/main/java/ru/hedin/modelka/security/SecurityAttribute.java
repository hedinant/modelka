package ru.hedin.modelka.security;

import org.springframework.security.access.ConfigAttribute;
import ru.hedin.modelka.security.UserRole;

import java.util.List;
import java.util.stream.Collectors;

public class SecurityAttribute implements ConfigAttribute {
    private final List<UserRole> roles;

    public List<UserRole> getRoles() { return roles; }

    public SecurityAttribute(List<UserRole> roles) {
        this.roles = roles;
    }

    @Override
    public String getAttribute() {
        return roles.stream()
                .map(UserRole::getAuthority)
                .collect(Collectors.joining(","));
    }
}
