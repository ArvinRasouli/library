package com.mupra.library.dao;

import com.mupra.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Integer> {

}
