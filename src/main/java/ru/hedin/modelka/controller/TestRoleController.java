package ru.hedin.modelka.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hedin.modelka.security.HasUserRoles;
import ru.hedin.modelka.security.UserRole;

@RestController("/test")
@RequestMapping("/test")
public class TestRoleController {


//@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@HasUserRoles({UserRole.ROLE_ADMIN})
    @GetMapping ("/admin")
    public String isAdmin(){
    SecurityContext securityContext = SecurityContextHolder.getContext();
//getAuthorities().toString() - 404
    //.getname() - work
    String str2= securityContext.getAuthentication().getName()+" ";
    str2+= " Hi ADmin";
    return str2;
    }
    @HasUserRoles({UserRole.ROLE_GM})
    @GetMapping ("/gm")
    public String isGm(){
        return "Hi GM";
    }

    @HasUserRoles({UserRole.ROLE_USER})
    @GetMapping ("/user")
    public String isUser(){
        return "Hi you just user";
    }


}
