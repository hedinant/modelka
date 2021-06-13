package ru.hedin.modelka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.hedin.modelka.domain.ModUser;
import ru.hedin.modelka.domain.RegistrationService;
import ru.hedin.modelka.service.TestRepository;
import ru.hedin.modelka.service.UserRepository;

@RestController("/register")
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private TestRepository testRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RegistrationService registrationService ;

    @GetMapping(name = "")
    public String test() {
        int size = testRepository.test();
        return "test_" + size;
    }

    @PostMapping(name = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String registration(@RequestBody ModUser requestModel) {

        ModUser modUser;

        modUser = userRepository.getUserByLogin(requestModel.getUserName());

        if (modUser != null) {
            return "Already Exist";
        }
// call Service
        if (registrationService.creteUser( requestModel)){
            return "All Ok";
        }
        return "something wrong";
    }


}
