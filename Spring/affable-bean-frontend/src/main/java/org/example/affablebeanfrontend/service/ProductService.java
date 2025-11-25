package org.example.affablebeanfrontend.service;

import lombok.RequiredArgsConstructor;
import org.example.affablebeanfrontend.ds.Product;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final  RestClient restClient;

    public ProductService(){
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8081/api/affablebean")
                .build();
    }

    public List<Product> getProducts(int id) {
      return   restClient.get()
                .uri("/product/{id}", id)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Product>>() {});
    }
}
