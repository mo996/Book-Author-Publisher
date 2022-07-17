package de.springframework.webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import de.springframework.webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
