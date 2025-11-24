package org.example.reactivedemo.service;

import org.example.reactivedemo.ds.Response;
import org.example.reactivedemo.util.EntityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class MathService {

    public ResponseEntity<Response> square(int number) {
        int result = number * number;
        return ResponseEntity.ok(new Response(result));
    }

    public List<Response> multiplicationTable(int number) {
      return   IntStream.rangeClosed(1,10)
                .map(i->i * number)
                .peek(a-> EntityUtil.pauseTime( 1500))
              .peek(i-> System.out.println("%d * %d = %d ."
                      .formatted(i,number,(i+number))))
                .mapToObj(Response::new)
                .toList();
    }
}
