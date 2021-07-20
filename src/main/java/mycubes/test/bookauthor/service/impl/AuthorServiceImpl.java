package mycubes.test.bookauthor.service.impl;

import mycubes.test.bookauthor.model.Author;
import mycubes.test.bookauthor.repository.AuthorRepository;
import mycubes.test.bookauthor.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        Author authorFromDb = authorRepository.findById(author.getId()).orElseThrow();
        authorFromDb.setAuthorName(author.getAuthorName());
        authorFromDb.setEmail(author.getEmail());
        authorFromDb.setBirthDate(author.getBirthDate());
        authorFromDb.setPhone(author.getPhone());
        return authorRepository.save(authorFromDb);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
