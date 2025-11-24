package org.example.reactivedemo.service;

import org.example.reactivedemo.ds.Response;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class ReactMathService {

    public Flux<Response> multiplicationTable(int number) {
        List<Response> responses = IntStream.range(1,10)
                .peek(i->)








//        return Flux.range(1, 10)
//
//               .doOnNext(i ->
//                       System.out.println("%d * %d =%d.\n"
//                               .formatted(i, number, (i * number))))
//                .map( i -> {
//                    System.out.println("%d * %d =%d");
//                //    i * number
//                })
//                .delayElements(Duration.of(1, ChronoUnit.SECONDS))
//                .map( i -> new Response(i));
    }
}