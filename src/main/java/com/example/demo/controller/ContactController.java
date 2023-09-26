package com.example.demo.controller;

import jakarta.websocket.server.PathParam;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author xiebiao@akulaku.com
 * @date 2023-09-26 11:28
 */
@Controller
public class ContactController {

    private List<Contact> contacts = List.of(
        new Contact("test1@qq.com", "Joe"),
        new Contact("like@qq.com", "Lily"),
        new Contact("ok@qq.com", "Sarah"));

    @GetMapping(path = {"/contact", "/contact/"})
    public String contact(Model model) {
        return "contact_index.html";
    }

    @RequestMapping(value = "/contacts", method = {RequestMethod.GET, RequestMethod.POST})
    public String contacts(
        @RequestParam(required = false) String q,
        @RequestParam(required = false) String other,
        Model model) {
        model.addAttribute("contacts", search(q));
        return "contacts.html";
    }

    @DeleteMapping(value = "/contacts/{id}")
    public RedirectView contactDelete(@PathVariable() int id) {
        this.contacts = contacts.stream().filter(item -> !item.getId().equals(id)).collect(Collectors.toList());
        RedirectView redirectView = new RedirectView("/contacts", true, false, false);
        redirectView.setUrl("/contacts");
        return redirectView;
    }

    private List<Contact> search(String q) {
        if (StringUtils.hasLength(q) == false) {
            return contacts;
        }
        return contacts.stream().filter(item -> item.getEmail().contains(q)).collect(Collectors.toList());
    }
}
