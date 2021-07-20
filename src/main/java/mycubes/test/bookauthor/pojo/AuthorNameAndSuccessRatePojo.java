package mycubes.test.bookauthor.pojo;

import lombok.Data;

@Data
public class AuthorNameAndSuccessRatePojo {
    private String authorName;
    private Float successRate;

    public AuthorNameAndSuccessRatePojo() {
    }

    public AuthorNameAndSuccessRatePojo(String authorName, Float successRate) {
        this.authorName = authorName;
        this.successRate = successRate;
    }
}
