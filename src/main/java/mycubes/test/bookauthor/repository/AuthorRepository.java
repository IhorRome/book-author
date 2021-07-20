package mycubes.test.bookauthor.repository;

import mycubes.test.bookauthor.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findFirstByAuthorName(String authorName);

    List<Author> findAllByAuthorNameContains(String partAuthorName);
}
