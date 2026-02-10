package com.assesment.booktracker.repository;

import com.assesment.booktracker.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Finds all books that belong to a specific user ID
    List<Book> findByUserId(Long userId);
}