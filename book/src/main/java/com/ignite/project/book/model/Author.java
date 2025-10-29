package com.ignite.project.book.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;
/**
  Author

 * This entity class represents an author in the database.
 * It maps to the "books_author" table and is linked to books
 * through a many-to-many relationship.
 *
 * Key Features:
 *  - Stores author information such as name and birth/death year.
 *  - Each author can have multiple books.
 *  - Helps in filtering and displaying author-related data.
 *
 * Author: Siddharth Kardile
 */
@Entity
@Table(name = "books_author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @JsonBackReference
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author() {}

    public Author(String name) {
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
