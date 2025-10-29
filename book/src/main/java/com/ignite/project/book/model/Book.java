package com.ignite.project.book.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.util.List;

/**
  Book

 * This entity class represents a book record from the database.
 * It maps to the "books_book" table and contains relationships
 * with authors, subjects, bookshelves, languages, and formats.
 *
 * Key Features:
 *  - Stores book details such as title, language, and download count.
 *  - Connected with multiple authors, subjects, and formats.
 *  - Used as the main entity for book-related operations.
 *
 * Author: Siddharth Kardile
 */
@Entity
@Table(name = "books_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "download_count")
    private int downloadCount;


    @JsonManagedReference
    @ManyToMany
    @JoinTable(
        name = "books_book_authors",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
        name = "books_book_subjects",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
        name = "books_book_bookshelves",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "bookshelf_id")
    )
    private List<Bookshelf> bookshelves;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
        name = "books_book_languages",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages;

    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private List<Format> formats;

    // ------------------ Constructors ------------------
    public Book() {}

    public Book(String title, int downloadCount) {
        this.title = title;
        this.downloadCount = downloadCount;
    }

    // ------------------ Getters & Setters ------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Bookshelf> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(List<Bookshelf> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Format> getFormats() {
        return formats;
    }

    public void setFormats(List<Format> formats) {
        this.formats = formats;
    }
}
