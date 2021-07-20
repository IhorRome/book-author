package mycubes.test.bookauthor.controller;

import mycubes.test.bookauthor.dto.request.AuthorRequestDto;
import mycubes.test.bookauthor.dto.response.AuthorResponseDto;
import mycubes.test.bookauthor.mapper.AuthorMapper;
import mycubes.test.bookauthor.service.AuthorService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    public AuthorController(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping
    public AuthorResponseDto create(@RequestBody AuthorRequestDto requestDto) {
        return authorMapper
                .modelToDto(authorService
                        .create(authorMapper
                                .dtoToModel(requestDto)));
    }

    @PutMapping
    public AuthorResponseDto update(@RequestBody AuthorRequestDto requestDto) {
        return authorMapper
                .modelToDto(authorService
                        .update(authorMapper
                                .dtoToModel(requestDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
}
