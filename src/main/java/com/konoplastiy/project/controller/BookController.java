package com.konoplastiy.project.controller;

import com.konoplastiy.project.entity.Book;
import com.konoplastiy.project.entity.MyBookList;
import com.konoplastiy.project.service.BookService;
import com.konoplastiy.project.service.MyBookListService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final MyBookListService myBookListService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook() {
        List<Book> list = bookService.getAllBook();
        return new ModelAndView("bookList", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/available_books";
    }

    @GetMapping("/my_book")
    public String getMyBooks(Model model) {
        List<MyBookList> list = myBookListService.getAllMyBooks();
        model.addAttribute("book", list);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b = bookService.getBookById(id);
        MyBookList bm = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookListService.saveMyBooks(bm);
        return "redirect:/my_book";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book b = bookService.getBookById(id);
        model.addAttribute("book", b);
        return "bookEdit";
    }
    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/available_books";
    }
}
