package ru.hedin.modelka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hedin.modelka.domain.ModUser;
import ru.hedin.modelka.model.UserDetailsRequestModel;
import ru.hedin.modelka.service.UserRepository;

import java.util.Collections;

@RestController("/log")
@RequestMapping("/log")
public class LoginController {
public InMemoryUserDetailsManager inMemoryUserDetailsManager;
    @Autowired
    UserRepository userRepository;

    @PostMapping( name = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String loginFromBase (@RequestBody UserDetailsRequestModel requestModel){

        ModUser modUser;
        String str = requestModel.getLogin();
        modUser = userRepository.getUserByLogin(str);
        String passwd = requestModel.getPassword();

        if (modUser == null) {return "no such user";}

        if (passwd.equals(modUser.getPassword())) {

            org.springframework.security.core.userdetails.User userd =
                    new org.springframework.security.core.userdetails.User(str, passwd, Collections.singletonList(new SimpleGrantedAuthority("USER")));

            inMemoryUserDetailsManager = new InMemoryUserDetailsManager(userd);
            return "all write";
        }

        return "wrong password";

    }

}
