package com.sut.lab.controllers;

import com.sut.lab.entities.Book;
import com.sut.lab.entities.BookType;
import com.sut.lab.repositories.BookTypeRepository;
import com.sut.lab.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lab")
@CrossOrigin("*")
public class Lab01Controller {

    @Autowired
    private BookService bookService;

//    http://localhost:8080/lab/input2
// http://localhost:8080/lab/input?a=1&b=2
    @GetMapping("/input")
    public Integer readInput(@RequestParam("a") Integer a,@RequestParam("b") Integer b){

        System.out.println(a);
        System.out.println(b);


//        BookService bookService = new BookService(); XXX


        return a+b;
    }

//  http://localhost:8080/lab/input
    @GetMapping("/input2")
    public String readInput2(){

        return "test lab";
    }



}
