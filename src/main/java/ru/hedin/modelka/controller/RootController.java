package ru.hedin.modelka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    @GetMapping("/")
    public String home(){
        return "THis is home to change 405";
    }
}
