package org.example.methodsecuritydemo.controller;

import org.example.methodsecuritydemo.ds.Product;
import org.example.methodsecuritydemo.service.PorductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    private PorductService porductService;

    @GetMapping("/product")
    public List<Product> getProduct(@RequestParam ("code")String code) {
        return porductService.getProducts(code);
    }
    @GetMapping("/product-V2")
    public List<Product> getProductV2(@RequestParam ("code")String code) {
        //var List = Arrays.asList();
        Map<String, List<Product> > maps =new HashMap<>();
                maps.put ("111",
                        List.of(new Product("john", List.of("Bear","Book","candy"))
                               ));
                maps.put ("112",
                        List.of(new Product("mary", List.of("Flowers","perfume"))
                             //    new Product("mary", List.of("Song","Clubs"))
                                  ));
        return porductService.getProductsV2(maps.get(code));
    }

}
