package org.example.methodsecuritydemo.ds;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String owner;
    private List<String> products =
            new ArrayList<>();

    public Product(String owner, List<String> products) {
        this.owner = owner;
        this.products = products;
    }

    public String getOwner() {
        return owner;
    }

    public List<String> getProducts() {
        return products;
    }


}
