package com.sut.lab.repositories;

import com.sut.lab.entities.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTypeRepository extends JpaRepository<BookType,Long> {


}
