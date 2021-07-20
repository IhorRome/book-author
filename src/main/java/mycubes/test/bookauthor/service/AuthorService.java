package mycubes.test.bookauthor.service;

import mycubes.test.bookauthor.model.Author;
import mycubes.test.bookauthor.pojo.AuthorNameAndSuccessRatePojo;

public interface AuthorService {
    Author create(Author author);

    Author update(Long id, Author author);

    void delete(Long id);

    AuthorNameAndSuccessRatePojo getMostSuccessfulAuthor();
}
