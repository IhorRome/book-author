package mycubes.test.bookauthor.dto.response;

import lombok.Data;

@Data
public class BookResponseDto {
    private Long id;
    private String bookName;
    private String authorName;
    private int publishedAmount; //amount of published book’s instances
    private int soldAmount;
}
