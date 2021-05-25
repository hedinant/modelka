package ru.hedin.modelka.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hedin.modelka.domain.ActionData;

@RestController("/action")
public class ActionController {

    @PostMapping()// http:..../action
    public String doAction(ActionData actionData){
        return "";
    }
}
