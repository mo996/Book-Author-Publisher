package de.springframework.webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import de.springframework.webapp.domain.Author;
import de.springframework.webapp.domain.Book;
import de.springframework.webapp.domain.Publisher;
import de.springframework.webapp.repositories.AuthorRepository;
import de.springframework.webapp.repositories.BookRepository;
import de.springframework.webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Publisher publisher = new Publisher("RheinWerk", "Alte Allee 68", "Munich", "Bayern", "81245");
		publisherRepository.save(publisher);

		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123123232");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);

		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(publisher);

		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("NoEJB", "123265676");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);

		noEJB.setPublisher(publisher);
		publisher.getBooks().add(noEJB);

		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisher);

		System.out.println("Number of publisher: " + publisherRepository.count());
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Publisher Number of books: " + publisher.getBooks().size());

	}

}
