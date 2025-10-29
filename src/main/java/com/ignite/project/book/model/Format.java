package com.ignite.project.book.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
  Format

 * This entity represents the available file formats for a specific book.
 * It maps to the "books_format" table and stores MIME type and URL data.
 *
 * Key Features:
 *  - Stores file format information like "text/plain".
 *  - Linked to a single book using a many-to-one relationship.
 *  - Used for providing download links to users.
 *
 * Author: Siddharth Kardile
 */
@Entity
@Table(name = "books_format")
public class Format {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mimeType;
    private String url;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Format() {}

    public Format(String mimeType, String url) {
        this.mimeType = mimeType;
        this.url = url;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
