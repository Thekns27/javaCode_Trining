package org.example.reactivedemo.controller;


import lombok.RequiredArgsConstructor;
import org.example.reactivedemo.ds.Response;
import org.example.reactivedemo.service.MathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/math")
public class MathController {

    private final MathService mathService;
    @GetMapping("/square/number")
    public ResponseEntity<Response>square(@PathVariable int  number){
        return mathService.square(number);
    }
    @GetMapping("/table/{number}")
    public List<Response> multiplicationTable(@PathVariable ("number") int number){
        return mathService.multiplicationTable(number);
    }
}
