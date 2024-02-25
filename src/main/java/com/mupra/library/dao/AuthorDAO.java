package com.mupra.library.dao;

import com.mupra.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDAO extends JpaRepository<Author, Integer> {

}
