package com.ignite.project.book.controller;

import com.ignite.project.book.service.BookService;
import com.ignite.project.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
  BookController

 * This class handles all incoming REST API requests related to books.
 * It provides endpoints for fetching books from the database with optional
 * filters such as language, author, title, subject, or mime-type.
  
 * Key Features:
 *  - Handles /api/books endpoint.
 *  - Supports pagination (25 books per page).
 *  - Supports sorting by download count.
 *  - Returns clean JSON responses using DTOs.
 
 * Author: Siddharth Kardile
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getBooks(
            @RequestParam Map<String, String> params,
            @RequestParam(defaultValue = "0") int page
    ) {
        Map<String, List<String>> filters = params.entrySet().stream()
                .filter(e -> !e.getKey().equals("page"))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> Arrays.asList(e.getValue().split(","))
                ));

        Map<String, Object> response = bookService.getBooks(filters, page);
        return ResponseEntity.ok(response);
    }
}
