package com.sut.lab.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "book_type")
public class BookType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookTypeId;

    @Column
    private String bookTypeName;

//    public Long getBookTypeId() {
//        return bookTypeId;
//    }
//
//    public void setBookTypeId(Long bookTypeId) {
//        this.bookTypeId = bookTypeId;
//    }
//
//    public String getBookTypeName() {
//        return bookTypeName;
//    }
//
//    public void setBookTypeName(String bookTypeName) {
//        this.bookTypeName = bookTypeName;
//    }
}
