package com.sut.lab.controllers;

import com.sut.lab.entities.BookType;
import com.sut.lab.repositories.BookTypeRepository;
import com.sut.lab.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book-type")
@CrossOrigin("*")
public class BookTypeController {

    @Autowired
    private BookTypeRepository bookTypeRepository;

    @Autowired
    private BookService bookService;



    @GetMapping("/book-type-by-id")
    public BookType findById(@RequestParam("id") Long id){

        BookType bookType = bookTypeRepository.findById(id).orElse(null);

        return bookType;
    }

    @PostMapping("/delete-book-type")
    public String deleteBookType(@RequestParam("id") Long id){

        //1
//        BookType bookType = bookTypeRepository.findById(id).orElse(null);
//        bookTypeRepository.delete(bookType);

        //2
        bookTypeRepository.deleteById(id);

        return "success";
    }

    //body
    //param http://localhost:8080/book-type/update-book-type?id=1
    //path /update-book-type/{id1}
    @PostMapping("/update-book-type")
    public String updateBookType(@RequestBody BookType bookType){

        Long bookTypeId = bookType.getBookTypeId();
        String bookTypeNameFromRequest = bookType.getBookTypeName();

        BookType bookTypeUpdate = bookTypeRepository.findById(bookTypeId).orElse(null);
        bookTypeUpdate.setBookTypeName(bookTypeNameFromRequest);
        bookTypeRepository.save(bookTypeUpdate);

        return "success";

    }

    @PostMapping("/save-book-type")
    public String saveBook(@RequestBody BookType bookType){


        bookTypeRepository.save(bookType);

        return "save success";
    }

    @GetMapping("/find-all")
    public List<BookType> findAll(){

        List<BookType> listBookType = bookTypeRepository.findAll();

        return listBookType;
    }





}
