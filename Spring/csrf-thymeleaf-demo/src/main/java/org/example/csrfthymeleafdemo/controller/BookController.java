package org.example.csrfthymeleafdemo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    record BookResponse(int id,String bookName){

        public List<BookResponse> getAllBook(){
            List.of(new BookResponse(1,"A pair of blue eye"));
                    (new BookResponse(2,"Blue Tales "));
        }
    }
}
