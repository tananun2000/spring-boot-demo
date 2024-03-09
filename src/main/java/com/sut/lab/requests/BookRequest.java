package com.sut.lab.requests;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class BookRequest {

    private Long bookId;

    private String bookName;

    private Date publishDate;

    private String author;

    private Long bookTypeId;

}
