package mycubes.test.bookauthor.dto.response;

import lombok.Data;

@Data
public class AuthorNameAndSuccessRateResponseDto {
    private String authorName;
    private float authorSuccessRate;
}
