package com.gmail.shelkovich.anton.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class WelcomController {
    @RequestMapping("/")
    public String loginPage() throws IOException {
        return "redirect:/login";
    }
}
