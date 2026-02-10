package com.assesment.booktracker.controller;

import com.assesment.booktracker.model.Book;
import com.assesment.booktracker.model.User;
import com.assesment.booktracker.repository.BookRepository;
import com.assesment.booktracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    // Helper method to get the currently logged-in user
    private User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    // 1. Get ALL Books (Only for this user)
    @GetMapping
    public List<Book> getAllBooks() {
        User user = getLoggedInUser();
        return bookRepository.findByUserId(user.getId());
    }

    // 2. Add a New Book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        User user = getLoggedInUser();
        book.setUser(user); // Link the book to the user
        return bookRepository.save(book);
    }

    // 3. Update a Book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        User user = getLoggedInUser();
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Security Check: Ensure the book belongs to the logged-in user
        if (!book.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You are not authorized to update this book");
        }

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setStatus(bookDetails.getStatus());
        
        return bookRepository.save(book);
    }

    // 4. Delete a Book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        User user = getLoggedInUser();
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (!book.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You are not authorized to delete this book");
        }

        bookRepository.delete(book);
        return "Book deleted successfully";
    }
}