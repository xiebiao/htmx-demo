package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xiebiao@akulaku.com
 * @date 2023-09-26 11:28
 */
@Controller
public class ContactController {

    @RequestMapping("/contact")
    public String contact(Model model) {

        return "contact_layout.html";
    }
}
