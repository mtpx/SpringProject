package dev.proj.project.application.controller;

import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class MainController {

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/users")
    public String users() {
        return "users";
    }

    @GetMapping(value = "/homes")
    public String homes() {
        return "homes";
    }

    @GetMapping(value = "/addresses")
    public String addresses() {
        return "addresses";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }
}
