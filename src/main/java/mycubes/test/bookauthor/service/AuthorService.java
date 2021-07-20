package mycubes.test.bookauthor.service;

import mycubes.test.bookauthor.model.Author;

public interface AuthorService {
    Author create(Author author);

    Author update(Long id, Author author);

    void delete(Long id);
}
