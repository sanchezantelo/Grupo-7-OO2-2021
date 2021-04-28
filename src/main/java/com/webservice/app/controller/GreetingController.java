package com.webservice.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping({ "/", "/index" })
    public String index(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        logger.info("Message" + name);
        model.addAttribute("name", name);
        return "index";
    }

    @PostMapping("/guardar")
    @ResponseBody
    public String post(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        logger.info("Message" + name);
        model.addAttribute("name", name);
        return model.getAttribute("name").toString();
    }
    

    // Login form
    @RequestMapping("/login.html")
    public String login() {
      return "login.html";
    }

    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
      model.addAttribute("loginError", true);
      return "login.html";
    }
}