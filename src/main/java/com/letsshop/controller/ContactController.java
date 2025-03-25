package com.letsshop.controller;

import com.letsshop.entities.Contact;
import com.letsshop.services.interfac.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitContactForm(@RequestBody Contact contact) {
        contactService.saveContact(contact);
        return ResponseEntity.ok("Your message has been sent successfully!");
    }
}

