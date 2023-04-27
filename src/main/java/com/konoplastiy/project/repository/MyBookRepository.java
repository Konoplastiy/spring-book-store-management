package com.konoplastiy.project.repository;

import com.konoplastiy.project.entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBookRepository extends JpaRepository<MyBookList, Integer> {
}
