package com.konoplastiy.project.service;

import com.konoplastiy.project.entity.Book;
import com.konoplastiy.project.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }

   public void deleteById(int id) {
        bookRepository.deleteById(id);
   }
}
