package org.example.affablebeanfrontend.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.affablebeanfrontend.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/products/{id}")
    public String listProductsByCategoryId(@PathVariable("id") int id, Model model) {
        model.addAttribute("products",productService.getProducts(id));
        return "products";

    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
