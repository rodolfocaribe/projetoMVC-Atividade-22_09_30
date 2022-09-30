package br.com.atividade22_09_30.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
