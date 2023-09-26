package com.example.demo.controller;

import java.security.SecureRandom;
import java.util.Random;
import lombok.Data;

/**
 * @author xiebiao@akulaku.com
 * @date 2023-09-26 15:18
 */
@Data
public class Contact {

    private Integer id;
    private String name;
    private String email;
    private static SecureRandom random = new SecureRandom();

    public Contact() {
    }

    public Contact(String email, String name) {
        this.id = random.nextInt(100);
        this.email = email;
        this.name = name;
    }

}
