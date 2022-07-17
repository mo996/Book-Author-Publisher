package de.springframework.webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import de.springframework.webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
