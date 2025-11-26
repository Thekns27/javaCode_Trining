package org.example.methodsecuritydemo.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NameService {
    private Map<String,String> secretName = Map.of(
            "ft","Fantasia",
            "ai","Aria",
            "bb","BomBom"
    );

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String getSecretName(String name){
        return secretName.get(name);
    }
}
