package mycubes.test.bookauthor.controller;

import mycubes.test.bookauthor.dto.request.BookRequestDto;
import mycubes.test.bookauthor.dto.response.BookAndSuccessRateResponseDto;
import mycubes.test.bookauthor.dto.response.BookResponseDto;
import mycubes.test.bookauthor.service.BookService;
import mycubes.test.bookauthor.mapper.BookMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService,
                          BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public BookResponseDto create(@RequestBody BookRequestDto requestDto) {
        return bookMapper
                .modelToDto(bookService
                        .create(bookMapper
                                .dtoToModel(requestDto)));
    }

    @PutMapping("/{id}")
    public BookResponseDto update(@PathVariable Long id, @RequestBody BookRequestDto requestDto) {
        return bookMapper
                .modelToDto(bookService
                        .update(id, bookMapper
                                .dtoToModel(requestDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @GetMapping("/by-author-name")
    public List<BookResponseDto> getByAuthorName(@RequestParam String authorName) {
        return bookService.findBooksByAuthorName(authorName)
                .stream()
                .map(bookMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/max-sold-by-author-name")
    public List<BookResponseDto> getBooksWithMaxSoldAmount(@RequestParam String authorName) {
        return bookService.getBooksWithMaxSoldAmountOfAuthor(authorName)
                .stream()
                .map(bookMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/max-published-by-author-name")
    public List<BookResponseDto> getBooksWithMaxPublishedAmount(@RequestParam String authorName) {
        return bookService.getBooksWithMaxPublishedAmountOfAuthor(authorName)
                .stream()
                .map(bookMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/max-sold-by-part-name")
    public List<BookResponseDto> getBooksWithMaxSoldAmountByPartAuthorName(
            @RequestParam String partAuthorName) {
        return bookService.getBooksWithMaxSoldAmountForAuthorsByPartOfName(partAuthorName)
                .stream()
                .map(bookMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/max-published-by-part-name")
    public List<BookResponseDto> getBooksWithMaxPublishedAmountByPartAuthorName(
            @RequestParam String partAuthorName) {
        return bookService.getBooksWithMaxPublishedAmountForAuthorsByPartOfName(partAuthorName)
                .stream()
                .map(bookMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most-success-rate-by-part-name")
    public List<BookAndSuccessRateResponseDto> getBooksWithMostSuccessRateForEachAuthor(
            @RequestParam String partAuthorName) {
        return bookService.getBooksWithGreatestSuccessRateOfAuthor(partAuthorName)
                .stream()
                .map(bookMapper::modelAndSuccessRateToDto)
                .collect(Collectors.toList());
    }
}
