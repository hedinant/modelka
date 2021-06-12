package ru.hedin.modelka.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import temp.User;

public class AuthProvider implements AuthenticationProvider {
//    @Authowired
//    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName().trim();
        String password = authentication.getCredentials().toString().trim();
////        User user = userRepository.getUserByLogin(username);
//        if (null == user) {
//            throw new BadCredentialsException("");
//        }
//        return localAuth(password, user);
        return localAuth(password, new User());
    }

    private Authentication localAuth(String password, User user) {
        String hash = password; //Тут hash алгорититм нужен
//        if (hash.equals(user.getPassword())) {
            return new AuthenticationImpl(user);
//        }
//        throw new BadCredentialsException("");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass));
    }
}
