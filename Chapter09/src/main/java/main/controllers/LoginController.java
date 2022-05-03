package main.controllers;

import main.entities.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(LoginProcessor processor, Model model) {
        model.addAttribute("message", processor.login() ? "You are now logged in." : "Login failed!");

        return "login.html";
    }
}
