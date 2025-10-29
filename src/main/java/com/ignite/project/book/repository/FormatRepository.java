package com.ignite.project.book.repository;

import com.ignite.project.book.model.Format;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
  FormatRepository

 * This interface manages database operations for the Format entity.
 * It provides CRUD access to book format records
 * and allows retrieving format URLs and MIME types for each book.
 *
 * Key Features:
 *  - Extends JpaRepository for built-in CRUD operations.
 *  - Can be expanded later for custom format-related queries.
 *  - Helps in fetching available download formats for books.
 *
 * Author: Siddharth Kardile
 */
@Repository
public interface FormatRepository extends JpaRepository<Format, Long> {
}
