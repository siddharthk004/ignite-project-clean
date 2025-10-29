package com.ignite.project.book.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import java.util.List;
/**
  Bookshelf

 * This entity represents the virtual bookshelf or collection
 * to which a book belongs.
 * It maps to the "books_bookshelf" table.
 *
 * Key Features:
 *  - Used to organize books into shelves or categories.
 *  - Supports many-to-many relationship with Book entity.
 *
 * Author: Siddharth Kardile
 */
@Entity
@Table(name = "books_bookshelf")
public class Bookshelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @JsonBackReference
    @ManyToMany(mappedBy = "bookshelves")
    private List<Book> books;

    public Bookshelf() {}

    public Bookshelf(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
