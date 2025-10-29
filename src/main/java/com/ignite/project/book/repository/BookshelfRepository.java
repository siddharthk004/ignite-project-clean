package com.ignite.project.book.repository;

import com.ignite.project.book.model.Bookshelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
  BookshelfRepository

 * This interface provides database access for the Bookshelf entity.
 * It manages bookshelf data such as "Best Books Ever Listings" and their relationships with books.
 *
 * Key Features:
 *  - Extends JpaRepository for easy CRUD and query operations.
 *  - Can be customized to add more bookshelf-related filters if needed.
 *  - Supports retrieving bookshelf names for displaying in API responses.
 *
 * Author: Siddharth Kardile
 */
@Repository
public interface BookshelfRepository extends JpaRepository<Bookshelf, Long> {
}
