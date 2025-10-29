package com.ignite.project.book.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import java.util.List;
/**
  Subject

 * This entity represents the subjects or topics that a book belongs to.
 * It maps to the "books_subject" table and connects to multiple books.
 *
 * Key Features:
 *  - Used to categorize books by their subjects.
 *  - Helps in implementing filtering by topic.
 *
 * Author: Siddharth Kardile
 */
@Entity
@Table(name = "books_subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @JsonBackReference
    @ManyToMany(mappedBy = "subjects")
    private List<Book> books;

    public Subject() {}

    public Subject(String name) {
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
