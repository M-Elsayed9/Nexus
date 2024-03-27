package com.nexus.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping("/login")
    public String login() {
        return "login-form";
    }

    @RequestMapping("/signup")
    public String signup() {
        return "register-form";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }
}
