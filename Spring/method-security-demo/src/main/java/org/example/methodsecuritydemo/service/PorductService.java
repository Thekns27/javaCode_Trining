package org.example.methodsecuritydemo.service;

import org.example.methodsecuritydemo.ds.Product;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PorductService {
    private Map<String, Product> maps =
            Map.of(
                    "111", new Product("mary",
                            List.of("Bear","Chocolate")),
                       "112", new Product("john",
                                    List.of("Gutter","Book"))
            );

    @PostFilter("filterObject.owner == authentication.name || filterObject.products.contains('Book')")
    public List<Product>getProducts(String code) {
        return List.of(maps.get(code));
    }
    @PreFilter("filterObject.owner == authentication.name")
    public List<Product> getProductsV2(List<Product> products) {
        return products;
    }
}
