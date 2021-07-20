package mycubes.test.bookauthor.repository;

import mycubes.test.bookauthor.model.Author;
import mycubes.test.bookauthor.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor(Author author);

    @Query(value = "SELECT b FROM Book b " +
            "where b.author = :author and " +
            "b.soldAmount = (select max(b.soldAmount) FROM Book b where b.author = :author)")
    List<Book> getAllByGreatestSoldAmountOfAuthor(Author author);

    @Query(value = "SELECT b FROM Book b " +
            "where b.author = :author and " +
            "b.publishedAmount = (select max(b.publishedAmount) FROM Book b where b.author = :author)")
    List<Book> getAllByGreatestPublishedAmountOfAuthor(Author author);

    @Query(value = "SELECT b FROM Book b " +
            "where b.author = :author and " +
            "b.soldAmount / b.publishedAmount = (select max(b.soldAmount / b.publishedAmount) " +
            "FROM Book b where b.author = :author)")
    List<Book> getAllByGreatestSuccessRateOfAuthor(Author author);

    @Query(value = "SELECT CAST(b.soldAmount/b.publishedAmount AS float) FROM Book b " +
            "WHERE b.id = :id")
    float getBookSuccessRateById(Long id);
}
