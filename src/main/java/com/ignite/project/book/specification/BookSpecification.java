package com.ignite.project.book.specification;

import com.ignite.project.book.model.*;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.*;
import java.util.*;

/**
  BookSpecification

 * This class builds dynamic JPA Specifications (WHERE clauses)
 * based on filters provided in the API request.
 * It allows searching and filtering books by multiple fields
 * such as author name, title, language, subject, and mime-type.
 *
 * Key Features:
 *  - Supports multiple filter conditions in a single request.
 *  - Allows case-insensitive and partial string matches.
 *  - Works with JpaSpecificationExecutor in BookRepository.
 *
 * Author: Siddharth Kardile
 */
public class BookSpecification {

    public static Specification<Book> withFilters(Map<String, List<String>> filters) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filter by language
            if (filters.containsKey("language")) {
                predicates.add(root.get("language").in(filters.get("language")));
            }

            if (filters.containsKey("title")) {
                List<Predicate> titlePreds = new ArrayList<>();
                for (String title : filters.get("title")) {
                    titlePreds.add(cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%"));
                }
                predicates.add(cb.or(titlePreds.toArray(new Predicate[0])));
            }

            // Filter by author 
            if (filters.containsKey("author")) {
                Join<Book, Author> author = root.join("author");
                List<Predicate> authorPreds = new ArrayList<>();
                for (String name : filters.get("author")) {
                    authorPreds.add(cb.like(cb.lower(author.get("name")), "%" + name.toLowerCase() + "%"));
                }
                predicates.add(cb.or(authorPreds.toArray(new Predicate[0])));
            }

            // Filter by topic 
            if (filters.containsKey("topic")) {
                List<Predicate> topicPreds = new ArrayList<>();
                Join<Book, Subject> subject = root.join("subjects", JoinType.LEFT);
                Join<Book, Bookshelf> bookshelf = root.join("bookshelves", JoinType.LEFT);

                for (String topic : filters.get("topic")) {
                    String pattern = "%" + topic.toLowerCase() + "%";
                    topicPreds.add(cb.like(cb.lower(subject.get("name")), pattern));
                    topicPreds.add(cb.like(cb.lower(bookshelf.get("name")), pattern));
                }
                predicates.add(cb.or(topicPreds.toArray(new Predicate[0])));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
