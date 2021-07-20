package mycubes.test.bookauthor.repository;

import mycubes.test.bookauthor.model.Author;
import mycubes.test.bookauthor.pojo.AuthorNameAndSuccessRatePojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findFirstByAuthorName(String authorName);

    List<Author> findAllByAuthorNameContains(String partAuthorName);

    @Query(value = "SELECT new mycubes.test.bookauthor.pojo.AuthorNameAndSuccessRatePojo(a.authorName, CAST(SUM(b.soldAmount / b.publishedAmount) / COUNT(*) AS float) AS successRate)\n" +
            "FROM Author a\n" +
            "LEFT JOIN Book b ON b.author = a\n" +
            "GROUP BY a.authorName\n" +
            "ORDER BY successRate DESC")
    List<AuthorNameAndSuccessRatePojo> getAuthorNameAndSuccessRate();
}
