package mycubes.test.bookauthor.dto.request;

import lombok.Data;

@Data
public class BookRequestDto {
    private String bookName;
    private Long authorId;
    private int publishedAmount; //amount of published book’s instances
    private int soldAmount;
}
