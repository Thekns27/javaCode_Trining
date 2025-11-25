package org.example.affablebeanfrontend;

import lombok.RequiredArgsConstructor;
import org.example.affablebeanfrontend.service.ProductService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class AffableBeanFrontendApplication {
    private final ProductService productService;


    public static void main(String[] args) {
        SpringApplication.run(AffableBeanFrontendApplication.class, args);
    }

}
