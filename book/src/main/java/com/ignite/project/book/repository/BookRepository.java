package com.ignite.project.book.repository;

import com.ignite.project.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
/**
  BookRepository

 * This interface handles all database operations related to the Book entity.
 * It extends JpaRepository for basic CRUD operations and
 * JpaSpecificationExecutor for dynamic filtering and searching.
 *
 * Key Features:
 *  - Provides access to all book records in the database.
 *  - Supports pagination and sorting through JPA.
 *  - Works with BookSpecification to apply filter conditions dynamically.
 *
 * Author: Siddharth Kardile
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
}
