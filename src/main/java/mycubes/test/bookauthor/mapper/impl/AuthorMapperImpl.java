package mycubes.test.bookauthor.mapper.impl;

import mycubes.test.bookauthor.dto.request.AuthorRequestDto;
import mycubes.test.bookauthor.dto.response.AuthorNameAndSuccessRateResponseDto;
import mycubes.test.bookauthor.dto.response.AuthorResponseDto;
import mycubes.test.bookauthor.mapper.AuthorMapper;
import mycubes.test.bookauthor.model.Author;
import mycubes.test.bookauthor.pojo.AuthorNameAndSuccessRatePojo;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements AuthorMapper {
    @Override
    public Author dtoToModel(AuthorRequestDto requestDto) {
        Author author = new Author();
        author.setAuthorName(requestDto.getAuthorName());
        author.setBirthDate(requestDto.getBirthDate());
        author.setPhone(requestDto.getPhone());
        author.setEmail(requestDto.getEmail());
        return author;
    }

    @Override
    public AuthorResponseDto modelToDto(Author author) {
        AuthorResponseDto responseDto = new AuthorResponseDto();
        responseDto.setId(author.getId());
        responseDto.setAuthorName(author.getAuthorName());
        responseDto.setBirthDate(author.getBirthDate());
        responseDto.setPhone(author.getPhone());
        responseDto.setEmail(author.getEmail());
        return responseDto;
    }

    @Override
    public AuthorNameAndSuccessRateResponseDto pojoToDto(AuthorNameAndSuccessRatePojo pojo) {
        AuthorNameAndSuccessRateResponseDto responseDto = new AuthorNameAndSuccessRateResponseDto();
        responseDto.setAuthorName(pojo.getAuthorName());
        responseDto.setAuthorSuccessRate(pojo.getSuccessRate());
        return responseDto;
    }
}
