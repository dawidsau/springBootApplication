package pl.sauermann.springBootApplication.bootstrap;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.sauermann.springBootApplication.model.Author;
import pl.sauermann.springBootApplication.model.Book;
import pl.sauermann.springBootApplication.model.Publisher;
import pl.sauermann.springBootApplication.repository.AuthorRepository;
import pl.sauermann.springBootApplication.repository.BookRepository;
import pl.sauermann.springBootApplication.repository.PublisherRepository;

@AllArgsConstructor
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        Publisher publisherOfJIAB = new Publisher("Somebody", "USA");
        Publisher publisherOfTJLS = new Publisher("Somebody", "USA");

        publisherRepository.save(publisherOfJIAB);
        publisherRepository.save(publisherOfTJLS);

        Author bc = new Author("Bruce", "Eckel");
        Book jiab = new Book("Java in a box", "1234");
        bc.getBooks().add(jiab);
        jiab.getAuthors().add(bc);
        jiab.setPublisher(publisherOfJIAB);

        authorRepository.save(bc);
        bookRepository.save(jiab);


        Author gb = new Author("Gilad", "Bracha");
        Book tjls = new Book("The Java Language Specification", "34");
        gb.getBooks().add(tjls);
        tjls.setPublisher(publisherOfTJLS);
        tjls.getAuthors().add(gb);

        authorRepository.save(gb);
        bookRepository.save(tjls);
    }

}
