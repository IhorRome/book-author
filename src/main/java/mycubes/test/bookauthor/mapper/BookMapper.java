package mycubes.test.bookauthor.mapper;

import mycubes.test.bookauthor.dto.request.BookRequestDto;
import mycubes.test.bookauthor.dto.response.BookAndSuccessRateResponseDto;
import mycubes.test.bookauthor.dto.response.BookResponseDto;
import mycubes.test.bookauthor.model.Book;

public interface BookMapper {
    Book dtoToModel(BookRequestDto requestDto);

    BookResponseDto modelToDto(Book book);

    BookAndSuccessRateResponseDto modelAndSuccessRateToDto(Book book);
}
