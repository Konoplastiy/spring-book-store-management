package com.konoplastiy.project.repository;

import com.konoplastiy.project.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
