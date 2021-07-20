package mycubes.test.bookauthor.service.impl;

import mycubes.test.bookauthor.model.Author;
import mycubes.test.bookauthor.pojo.AuthorNameAndSuccessRatePojo;
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
    public Author update(Long id, Author author) {
        Author authorFromDb = authorRepository.findById(id).orElseThrow();
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

    @Override
    public AuthorNameAndSuccessRatePojo getMostSuccessfulAuthor() {
        return authorRepository.getAuthorNameAndSuccessRate().get(0);
    }
}
