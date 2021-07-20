package mycubes.test.bookauthor.service;

import mycubes.test.bookauthor.model.Author;

import java.util.List;

public interface AuthorService {
    Author create(Author author);

    Author update(Author author);

    void delete(Long id);
}
