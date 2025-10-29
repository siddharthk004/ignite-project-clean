package com.ignite.project.book.repository;

import com.ignite.project.book.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
  SubjectRepository

 * This interface provides CRUD access for the Subject entity.
 * It is used to fetch and manage subject-related data for books.
 *
 * Key Features:
 *  - Simplifies database operations for subjects.
 *  - Can be extended for custom queries later if needed.
 *
 * Author: Siddharth Kardile
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
