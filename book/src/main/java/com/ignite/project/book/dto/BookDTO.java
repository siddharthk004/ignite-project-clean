package com.ignite.project.book.dto;

import java.util.List;
/**
  BookDTO

 * This Data Transfer Object (DTO) is used to send simplified and clean
 * book-related data in JSON format from the backend to the client.
 * It avoids circular references and includes only required fields.
 
 * Key Features:
 *  - Contains essential book details like title, authors, subjects, and formats.
 *  - Used by BookService to prepare API response.
 *  - Helps in separating entity logic from API response logic.
 
 * Author: Siddharth Kardile
 */
public class BookDTO {
    private Long id;
    private String title;
    private int downloadCount;
    private List<String> authors;
    private List<String> languages;
    private List<String> subjects;
    private List<String> bookshelves;
    private List<FormatDTO> formats;

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getDownloadCount() { return downloadCount; }
    public void setDownloadCount(int downloadCount) { this.downloadCount = downloadCount; }

    public List<String> getAuthors() { return authors; }
    public void setAuthors(List<String> authors) { this.authors = authors; }

    public List<String> getLanguages() { return languages; }
    public void setLanguages(List<String> languages) { this.languages = languages; }

    public List<String> getSubjects() { return subjects; }
    public void setSubjects(List<String> subjects) { this.subjects = subjects; }

    public List<String> getBookshelves() { return bookshelves; }
    public void setBookshelves(List<String> bookshelves) { this.bookshelves = bookshelves; }

    public List<FormatDTO> getFormats() { return formats; }
    public void setFormats(List<FormatDTO> formats) { this.formats = formats; }
}
