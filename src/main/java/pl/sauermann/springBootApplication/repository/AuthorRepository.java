package pl.sauermann.springBootApplication.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sauermann.springBootApplication.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
