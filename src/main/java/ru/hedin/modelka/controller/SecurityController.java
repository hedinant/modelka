package ru.hedin.modelka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.hedin.modelka.domain.ModUser;
import ru.hedin.modelka.security.UserRole;
import ru.hedin.modelka.service.UserRepository;

import java.security.Principal;
import java.util.Set;

@RestController
    public class SecurityController {

    @Autowired
    UserRepository rep;

        @RequestMapping(value = "/username", method = RequestMethod.GET)
        @ResponseBody
 //       @PreAuthorize("isAuthenticated()")
        // Principal is null -  strange
        public String currentUserName (Authentication authentication) {
            // String to collect info
            String str="";
            // Principal info
        // странным образом стал выдавать нул поинтер на аут.гетнаме
            if (authentication==null){return "Not logged in";}

            str = " principal name  "+authentication.getName()+"\n";
            // ROles
  //          for (UserRole role: UserRole.values()  ) {
   //             str+= "ROle name "+role.name()+" ROle ordinal "+role.ordinal()+"/n  ";
     //       }
// ROles from user
            ModUser user = rep.getUserByLogin(authentication.getName());
            Set<UserRole> ur = user.getRoles();
            str+=ur.toString();

            return str;
        }
    }


