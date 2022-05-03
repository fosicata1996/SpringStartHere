package main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home(@RequestParam(required = false, defaultValue = "FOSI") String name,
                       @RequestParam(required = false, defaultValue = "red") String color,
                       Model page) {
        page.addAttribute("username", name);
        page.addAttribute("color", color);

        return "home.html";
    }
}
