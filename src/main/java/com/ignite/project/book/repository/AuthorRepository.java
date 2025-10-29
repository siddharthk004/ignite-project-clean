package com.ignite.project.book.repository;

import com.ignite.project.book.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
  AuthorRepository

 * This interface manages database interactions for the Author entity.
 * It extends JpaRepository to provide CRUD operations without writing SQL.
 *
 * Key Features:
 *  - Fetches author details from the database.
 *  - Can be extended later for custom author queries if required.
 *
 * Author: Siddharth Kardile
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
