package de.springframework.webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import de.springframework.webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
