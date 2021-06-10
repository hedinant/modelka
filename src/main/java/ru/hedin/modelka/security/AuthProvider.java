package ru.hedin.modelka.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import ru.hedin.modelka.domain.ModUser;
import ru.hedin.modelka.service.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import temp.User;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthProvider implements AuthenticationProvider {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName().trim();
        String password = authentication.getCredentials().toString().trim();
        ModUser user = userRepository.getUserByLogin(username);
        if (null == user) {
            throw new BadCredentialsException("");
        }
//        return localAuth(password, user);
        return localAuth(password, user);
    }

    private Authentication localAuth(String password, ModUser user)  {
   //     String hash = password; //Тут hash алгорититм нужен
        // Hash похоже лишнийtemp = "827ccb0eea8a706c4c34a16891f84e7b" - 12345
        String md5Hex = DigestUtils
                .md5Hex(password).toLowerCase();

        if (md5Hex.equals(user.getPassword())) {
            return new AuthenticationImpl(user);
        }
        throw new BadCredentialsException("");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass));
    }
}
