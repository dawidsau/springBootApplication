package pl.sauermann.springBootApplication.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sauermann.springBootApplication.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
