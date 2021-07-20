package mycubes.test.bookauthor.mapper.impl;

import mycubes.test.bookauthor.dto.request.BookRequestDto;
import mycubes.test.bookauthor.dto.response.BookAndSuccessRateResponseDto;
import mycubes.test.bookauthor.dto.response.BookResponseDto;
import mycubes.test.bookauthor.model.Book;
import mycubes.test.bookauthor.repository.AuthorRepository;
import mycubes.test.bookauthor.mapper.BookMapper;
import mycubes.test.bookauthor.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookMapperImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Book dtoToModel(BookRequestDto requestDto) {
        Book book = new Book();
        book.setBookName(requestDto.getBookName());
        book.setAuthor(authorRepository.getById(requestDto.getAuthorId()));
        book.setSoldAmount(requestDto.getSoldAmount());
        book.setPublishedAmount(requestDto.getPublishedAmount());
        return book;
    }

    @Override
    public BookResponseDto modelToDto(Book book) {
        BookResponseDto responseDto = new BookResponseDto();
        responseDto.setId(book.getId());
        responseDto.setBookName(book.getBookName());
        responseDto.setAuthorName(book.getAuthor().getAuthorName());
        responseDto.setPublishedAmount(book.getPublishedAmount());
        responseDto.setSoldAmount(book.getSoldAmount());
        return responseDto;
    }

    @Override
    public BookAndSuccessRateResponseDto modelAndSuccessRateToDto(Book book) {
        BookAndSuccessRateResponseDto responseDto = new BookAndSuccessRateResponseDto();
        responseDto.setId(book.getId());
        responseDto.setBookName(book.getBookName());
        responseDto.setAuthorName(book.getAuthor().getAuthorName());
        responseDto.setPublishedAmount(book.getPublishedAmount());
        responseDto.setSoldAmount(book.getSoldAmount());
        responseDto.setSuccessRate(bookRepository.getBookSuccessRateById(book.getId()));
        return responseDto;
    }
}
