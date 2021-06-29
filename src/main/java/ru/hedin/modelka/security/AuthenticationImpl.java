package ru.hedin.modelka.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import ru.hedin.modelka.domain.ModUser;
import temp.User;

import java.util.Collection;

public class AuthenticationImpl implements Authentication {
    private ModUser user;
    private boolean authenticated;
    private SecurityUserDetails userDetails;

    public AuthenticationImpl(ModUser user) {
        userDetails = new SecurityUserDetails(user);
        this.user = user;
        authenticated = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles();
    }

    @Override
    public Object getCredentials() {
        return user.getLogin();
    }

    @Override
    public Object getDetails() {
        return userDetails;
    }

    @Override
    public Object getPrincipal() {
        return userDetails;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        authenticated = b;
    }

    @Override
    public String getName() {
        return user.getLogin();
    }

    public ModUser getUser() {
        return user;
    }
}
