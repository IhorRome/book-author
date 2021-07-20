package mycubes.test.bookauthor.mapper;

import mycubes.test.bookauthor.dto.request.AuthorRequestDto;
import mycubes.test.bookauthor.dto.response.AuthorResponseDto;
import mycubes.test.bookauthor.model.Author;

public interface AuthorMapper {
    Author dtoToModel(AuthorRequestDto requestDto);

    AuthorResponseDto modelToDto(Author author);
}
