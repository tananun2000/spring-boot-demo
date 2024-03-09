package com.sut.lab.repositories;

import com.sut.lab.entities.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookTypeRepository extends JpaRepository<BookType,Long> {

    //Query Methods
    List<BookType> findByBookTypeName(String bookTypeName);

    List<BookType> findByBookTypeNameLike(String bookTypeName);

    List<BookType> findByBookTypeNameContaining(String bookTypeName);


    // SQL native query
    @Query(value = "SELECT * FROM book_type where book_type_id = :bookTypeId",nativeQuery = true)
    BookType findBookTypeById(@Param("bookTypeId") Long bookTypeId);

    @Query(value = "SELECT * FROM book_type " +
            " where book_type_name like :input",nativeQuery = true)
    List<BookType> findCustomLikeBookTypeName(@Param("input") String input);


    //hql
    @Query(value = "SELECT o FROM BookType o " +
            " where o.bookTypeName like :input")
    List<BookType> findCustomLikeBookTypeNameByHQL(@Param("input") String input);

}
