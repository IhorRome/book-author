package mycubes.test.bookauthor.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    @ManyToOne
    private Author author;
    private int publishedAmount; //amount of published book’s instances
    private int soldAmount; //amount of sold book’s instances
}
