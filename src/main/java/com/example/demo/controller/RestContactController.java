package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiebiao@akulaku.com
 * @date 2023-09-26 11:28
 */
@RestController
@RequestMapping("/rest")
public class RestContactController {

    @GetMapping("/contact/count")
    public Integer getContactCount() {
        return 100;
    }
}
