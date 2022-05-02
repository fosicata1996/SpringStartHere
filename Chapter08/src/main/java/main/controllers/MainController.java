package main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home(Model page) {
        page.addAttribute("username", "Fosi");
        page.addAttribute("color", "red");

        return "home.html";
    }
}
