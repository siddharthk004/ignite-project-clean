package com.ignite.project.book.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ignite.project.book.dto.BookDTO;
import com.ignite.project.book.dto.FormatDTO;
import com.ignite.project.book.model.Author;
import com.ignite.project.book.model.Book;
import com.ignite.project.book.model.Bookshelf;
import com.ignite.project.book.model.Language;
import com.ignite.project.book.model.Subject;
import com.ignite.project.book.repository.BookRepository;
import com.ignite.project.book.specification.BookSpecification;
/**
  BookService

 * This service class contains the main business logic for the book module.
 * It interacts with the BookRepository and BookSpecification to fetch,
 * filter, and prepare book data for the controller layer.
 *
 * Key Features:
 *  - Applies dynamic filters (author, language, subject, title, mime-type).
 *  - Supports pagination (25 books per page) and sorting by popularity.
 *  - Converts Book entities into BookDTOs for clean JSON responses.
 *  - Uses @Transactional(readOnly = true) to prevent LazyInitialization issues.
 *
 * Author: Siddharth Kardile
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional(readOnly = true)
    public Map<String, Object> getBooks(Map<String, List<String>> filters, int page) {
        Pageable pageable = PageRequest.of(page, 25, Sort.by(Sort.Direction.DESC, "downloadCount"));
        Specification<Book> spec = BookSpecification.withFilters(filters);
        Page<Book> result = bookRepository.findAll(spec, pageable);
    
        List<BookDTO> dtoList = result.getContent().stream().map(book -> {
            BookDTO dto = new BookDTO();
            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            dto.setDownloadCount(book.getDownloadCount());
    
            dto.setAuthors(book.getAuthors().stream()
                    .map(Author::getName)
                    .toList());
    
            dto.setLanguages(book.getLanguages().stream()
                    .map(Language::getCode)
                    .toList());
    
            dto.setSubjects(book.getSubjects().stream()
                    .map(Subject::getName)
                    .toList());
    
            dto.setBookshelves(book.getBookshelves().stream()
                    .map(Bookshelf::getName)
                    .toList());
    
            dto.setFormats(book.getFormats().stream()
                    .map(f -> new FormatDTO(f.getMimeType(), f.getUrl()))
                    .toList());
    
            return dto;
        }).toList();
    
        Map<String, Object> response = new HashMap<>();
        response.put("totalCount", result.getTotalElements());
        response.put("books", dtoList);
        return response;
    }
    
}
