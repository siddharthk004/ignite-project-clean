package com.ignite.project.book.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import java.util.List;
/**
  Language

 * This entity represents the language in which a book is available.
 * It maps to the "books_language" table and connects with books
 * through a many-to-many relationship.
 *
 * Key Features:
 *  - Stores short language codes like "en", "fr", "de".
 *  - Helps filter books by their language.
 *
 * Author: Siddharth Kardile
 */
@Entity
@Table(name = "books_language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;
    @JsonBackReference
    @ManyToMany(mappedBy = "languages")
    private List<Book> books;

    // --- Constructors ---
    public Language() {}

    public Language(String code) {
        this.code = code;
    }

    // --- Getters and Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
