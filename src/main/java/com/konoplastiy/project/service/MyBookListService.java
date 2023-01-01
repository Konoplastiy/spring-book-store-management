package com.konoplastiy.project.service;

import com.konoplastiy.project.entity.MyBookList;
import com.konoplastiy.project.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {

    private MyBookRepository myBookRepository;

    @Autowired
    public MyBookListService(MyBookRepository myBookRepository) {
        this.myBookRepository = myBookRepository;
    }

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
