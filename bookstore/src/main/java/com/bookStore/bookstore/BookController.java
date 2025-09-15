package com.bookStore.bookstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;


@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    MyBookService myBookService;
    
    @GetMapping("/")
    public String home() {
        return "home"; // This will map to src/main/resources/templates/home.html
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister"; // This will map to src/main/resources/templates/book_register.html
    }
    
    @GetMapping("/available_books")
    public ModelAndView getAvailableBooks() {
        List<Book> list = bookService.getAllBooks();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("bookList");
        mv.addObject("book", list);
        return mv; // This will map to src/main/resources/templates/available_books.html
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        List<MyBookList> list = myBookService.getAllMyBooks();
        model.addAttribute("book", list);
        return "myBooks"; // This will map to src/main/resources/templates/my_books.html
    }
    

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book myBook) {
        bookService.saveBook(myBook);
        return "redirect:/available_books";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable Integer id) {
        Book book = bookService.getBookById(id);
        MyBookList myBook = new MyBookList();
        myBook.setId(book.getId());
        myBook.setTitle(book.getTitle());
        myBook.setAuthor(book.getAuthor());
        myBook.setPrice(book.getPrice());
        myBookService.saveMyBook(myBook);
        return "redirect:/my_books";
    }
    
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable Integer id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookEdit"; // This will map to src/main/resources/templates/bookEdit.html
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return "redirect:/available_books";
    }
}
