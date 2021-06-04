package ru.hedin.modelka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hedin.modelka.service.TestRepository;

@RestController("/register")
public class RegistrationController {
    @Autowired
    private TestRepository testRepository;
    @GetMapping
    public String test(){
        testRepository.test();
        return "";
    }
}
