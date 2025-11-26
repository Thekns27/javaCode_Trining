package org.example.authorizationbydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/products")
    public String products(){
        return "products";
    }
    // http://localhost:8080/products/category/details
    // products/category/details
    @GetMapping("/store")
    public String store(){
        return "store";
    }
    @GetMapping("products/category/details")
    public String details(){
        return "Product details";
    }
}