package com.sut.lab.entities;

//import javax.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column
    private String bookName;

    @Column
    private String author;

    @Column
    private Date publishDate;

    @JoinColumn(name = "book_type_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private BookType bookType;



}
