package com.konoplastiy.project.service;

import com.konoplastiy.project.entity.MyBookList;
import com.konoplastiy.project.repository.MyBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MyBookListService {

    private final MyBookRepository myBookRepository;

    public void saveMyBooks(MyBookList book) {
        myBookRepository.save(book);
    }

    public List<MyBookList> getAllMyBooks() {
        return myBookRepository.findAll();
    }

    public void deleteById(int id) {
        myBookRepository.deleteById(id);
    }
}
