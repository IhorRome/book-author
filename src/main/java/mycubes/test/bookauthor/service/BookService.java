package mycubes.test.bookauthor.service;

import mycubes.test.bookauthor.model.Author;
import mycubes.test.bookauthor.model.Book;

import java.util.List;

public interface BookService {
    Book create(Book book);

    Book update(Book book);

    void delete(Long id);

    List<Book> findBooksByAuthorName(String authorName);

    List<Book> getBooksWithMaxSoldAmountOfAuthor(String authorName);

    List<Book> getBooksWithMaxPublishedAmountOfAuthor(String authorName);

    List<Book> getBooksWithMaxSoldAmountForAuthorsByPartOfName(String partAuthorName);

    List<Book> getBooksWithMaxPublishedAmountForAuthorsByPartOfName(String partAuthorName);

    List<Book> getBooksWithGreatestSuccessRateOfAuthor(String partAuthorName);
}
