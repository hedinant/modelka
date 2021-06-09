package ru.hedin.modelka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.hedin.modelka.domain.ModUser;
import ru.hedin.modelka.domain.RegistrationService;
import ru.hedin.modelka.model.UserDetailsRequestModel;
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
    RegistrationService rs ;

    @GetMapping(name = "")
    public String test() {
        int size = testRepository.test();
        return "test_" + size;
    }

    @PostMapping(name = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String registration(@RequestBody UserDetailsRequestModel requestModel) {

        ModUser modUser;

        modUser = userRepository.findUserByName(requestModel.getLogin());

        if (modUser != null) {
            return "Already Exist";
        }
        modUser = new ModUser();
                modUser.setUserName(requestModel.getLogin());
                modUser.setPassword(requestModel.getPassword());

// call Service
        if (rs.creteUser( modUser)){
            return "All Ok";
        }

        return "something wrong";
    }


}
