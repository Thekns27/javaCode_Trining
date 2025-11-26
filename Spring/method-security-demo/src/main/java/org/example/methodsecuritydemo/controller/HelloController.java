package org.example.methodsecuritydemo.controller;

import org.example.methodsecuritydemo.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private NameService nameService;

    @GetMapping("/home")
    public String home() {
        return "Home";
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String getSecretName(@PathVariable("name")String name){
        return nameService.getSecretName(name);
    }
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/say-greeting")
    public String sayGreeting() {
        return "Hello";

    }
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/Products")
    public String getProducts() {
        return "Products";
    }
}
