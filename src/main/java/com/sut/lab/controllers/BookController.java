package com.sut.lab.controllers;

import com.sut.lab.entities.Book;
import com.sut.lab.entities.BookType;
import com.sut.lab.repositories.BookRepository;
import com.sut.lab.repositories.BookTypeRepository;
import com.sut.lab.requests.BookRequest;
import com.sut.lab.responses.APIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookTypeRepository bookTypeRepository;

    @PostMapping("/create-book")
    public APIResult createBook(@RequestBody BookRequest bookRequest){

        Long bookTypeId = bookRequest.getBookTypeId();
        BookType bookType = bookTypeRepository.findById(bookTypeId).orElse(null);

        bookRequest.getBookTypeId();
        Book book = new Book();
        book.setBookName(bookRequest.getBookName());
        book.setAuthor(bookRequest.getAuthor());
        book.setPublishDate(bookRequest.getPublishDate());
        book.setBookType(bookType);

        bookRepository.save(book);

        APIResult apiResult = new APIResult("success");
        return apiResult;
    }

    @PostMapping("/update-book")
    public APIResult updateBook(@RequestBody BookRequest bookRequest){

        Long bookTypeId = bookRequest.getBookTypeId();
        BookType bookType = bookTypeRepository.findById(bookTypeId).orElse(null);

        bookRequest.getBookTypeId();
        Book book = bookRepository.findById(bookRequest.getBookId()).orElse(null);
        book.setBookName(bookRequest.getBookName());
        book.setAuthor(bookRequest.getAuthor());
        book.setPublishDate(bookRequest.getPublishDate());
        book.setBookType(bookType);

        bookRepository.save(book);

        APIResult apiResult = new APIResult("success");
//        apiResult.setMessage("success");

        return apiResult;
    }

}
