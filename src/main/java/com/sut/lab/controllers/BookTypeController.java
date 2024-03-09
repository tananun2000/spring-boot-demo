package com.sut.lab.controllers;

import com.sut.lab.entities.BookType;
import com.sut.lab.repositories.BookTypeRepository;
import com.sut.lab.requests.BookTypeSearchRequest;
import com.sut.lab.responses.APIResult;
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

import java.util.ArrayList;
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

//        BookType bookType = bookTypeRepository.findById(id).orElse(null);
        BookType bookType = bookTypeRepository.findBookTypeById(id);

        return bookType;
    }

    @PostMapping("/delete-book-type")
    public APIResult deleteBookType(@RequestParam("id") Long id){

        //1
//        BookType bookType = bookTypeRepository.findById(id).orElse(null);
//        bookTypeRepository.delete(bookType);

        //2
        bookTypeRepository.deleteById(id);

        APIResult apiResult = new APIResult("success");

        return apiResult;
    }

    //body
    //param http://localhost:8080/book-type/update-book-type?id=1
    //path /update-book-type/{id1}
    @PostMapping("/update-book-type")
    public APIResult updateBookType(@RequestBody BookType bookType){

        Long bookTypeId = bookType.getBookTypeId();
        String bookTypeNameFromRequest = bookType.getBookTypeName();

        BookType bookTypeUpdate = bookTypeRepository.findById(bookTypeId).orElse(null);
        bookTypeUpdate.setBookTypeName(bookTypeNameFromRequest);
        bookTypeRepository.save(bookTypeUpdate);

        APIResult apiResult = new APIResult("success");
        return apiResult;

    }

    @PostMapping("/save-book-type")
    public APIResult saveBook(@RequestBody BookType bookType){


        bookTypeRepository.save(bookType);

        APIResult apiResult = new APIResult("success");

        return apiResult;
    }

    @GetMapping("/find-all")
    public List<BookType> findAll(){

        List<BookType> listBookType = bookTypeRepository.findAll();

        return listBookType;
    }


    @PostMapping("/search")
    public List<BookType> searchBookType(@RequestBody BookTypeSearchRequest request){


        String input = "%"+request.getInput()+"%";

//        List<BookType> listBookType = bookTypeRepository.findByBookTypeName(input);

//        List<BookType> listBookType = bookTypeRepository.findByBookTypeNameContaining(input);
//        List<BookType> listBookType = bookTypeRepository.findByBookTypeNameContaining(input);
//        List<BookType> listBookType = bookTypeRepository.findCustomLikeBookTypeName(input);
          List<BookType> listBookType = bookTypeRepository.findCustomLikeBookTypeNameByHQL(input);


        return listBookType;
    }





}
