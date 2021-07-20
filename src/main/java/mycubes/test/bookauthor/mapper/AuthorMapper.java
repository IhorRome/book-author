package mycubes.test.bookauthor.mapper;

import mycubes.test.bookauthor.dto.request.AuthorRequestDto;
import mycubes.test.bookauthor.dto.response.AuthorNameAndSuccessRateResponseDto;
import mycubes.test.bookauthor.dto.response.AuthorResponseDto;
import mycubes.test.bookauthor.model.Author;
import mycubes.test.bookauthor.pojo.AuthorNameAndSuccessRatePojo;

public interface AuthorMapper {
    Author dtoToModel(AuthorRequestDto requestDto);

    AuthorResponseDto modelToDto(Author author);

    AuthorNameAndSuccessRateResponseDto pojoToDto(AuthorNameAndSuccessRatePojo pojo);
}
