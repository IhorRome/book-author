package mycubes.test.bookauthor.service.impl;

import mycubes.test.bookauthor.model.Author;
import mycubes.test.bookauthor.model.Book;
import mycubes.test.bookauthor.repository.AuthorRepository;
import mycubes.test.bookauthor.repository.BookRepository;
import mycubes.test.bookauthor.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        Book bookFromDb = bookRepository.findById(book.getId()).orElseThrow();
        bookFromDb.setBookName(book.getBookName());
        bookFromDb.setAuthor(book.getAuthor());
        bookFromDb.setPublishedAmount(book.getPublishedAmount());
        bookFromDb.setSoldAmount(book.getSoldAmount());
        return bookRepository.save(bookFromDb);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findBooksByAuthorName(String authorName) {
        Author author = authorRepository.findFirstByAuthorName(authorName).orElseThrow();
        return bookRepository.findAllByAuthor(author);
    }

    @Override
    public List<Book> getBooksWithMaxSoldAmountOfAuthor(String authorName) {
        Author author = authorRepository.findFirstByAuthorName(authorName).orElseThrow();
        return bookRepository.getAllByGreatestSoldAmountOfAuthor(author);
    }

    @Override
    public List<Book> getBooksWithMaxPublishedAmountOfAuthor(String authorName) {
        Author author = authorRepository.findFirstByAuthorName(authorName).orElseThrow();
        return bookRepository.getAllByGreatestPublishedAmountOfAuthor(author);
    }

    @Override
    public List<Book> getBooksWithMaxSoldAmountForAuthorsByPartOfName(String partAuthorName) {
        List<Author> authors = authorRepository.findAllByAuthorNameContains(partAuthorName);
        List<Book> books = new ArrayList<>();
        for (Author author : authors) {
            books.addAll(bookRepository.getAllByGreatestSoldAmountOfAuthor(author));
        }
        return books;
    }

    @Override
    public List<Book> getBooksWithMaxPublishedAmountForAuthorsByPartOfName(String partAuthorName) {
        List<Author> authors = authorRepository.findAllByAuthorNameContains(partAuthorName);
        List<Book> books = new ArrayList<>();
        for (Author author : authors) {
            books.addAll(bookRepository.getAllByGreatestPublishedAmountOfAuthor(author));
        }
        return books;
    }

    @Override
    public List<Book> getBooksWithGreatestSuccessRateOfAuthor(String partAuthorName) {
        List<Author> authors = authorRepository.findAllByAuthorNameContains(partAuthorName);
        List<Book> books = new ArrayList<>();
        for (Author author : authors) {
            books.addAll(bookRepository.getAllByGreatestSuccessRateOfAuthor(author));
        }
        return books;
    }
}
