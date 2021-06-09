package ru.hedin.modelka.controller;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
    public class SecurityController {

        @RequestMapping(value = "/username", method = RequestMethod.GET)
        @ResponseBody
        public String currentUserName(Principal authentication) {
            return " principal name  "+authentication.getName() + " it was left from this";
        }
    }


