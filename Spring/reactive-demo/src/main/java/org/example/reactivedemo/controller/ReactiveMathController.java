package org.example.reactivedemo.controller;

import lombok.RequiredArgsConstructor;
import org.example.reactivedemo.ds.Response;
import org.example.reactivedemo.service.ReactMathService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reactive")
public class ReactiveMathController {
    private final ReactMathService reactMathService;

    @GetMapping(value = "/table/{number}",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
        public Flux<Response> multiplicationTable(@PathVariable ("number")int number) {
        return reactMathService.multiplicationTable(number);
    }
}
