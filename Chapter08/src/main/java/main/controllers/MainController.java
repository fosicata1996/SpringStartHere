package main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/{name}/{color}")
    public String home(@PathVariable String name,
                       @PathVariable String color,
                       Model page) {
        page.addAttribute("username", name);
        page.addAttribute("color", color);

        return "home.html";
    }
}
