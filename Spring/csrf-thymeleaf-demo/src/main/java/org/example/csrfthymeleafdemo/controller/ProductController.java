package org.example.csrfthymeleafdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private Logger logger= LoggerFactory.getLogger(ProductController.class.getName());
    @GetMapping("/")
    public String main(){
        return "main";
    }
    @PostMapping("/add-product")
    public String addProduct(@RequestParam("product")String name){
        return "main";
    }
}
