package bookstore.bims.book_api.controller;

import bookstore.bims.book_api.dto.AuthorDTO;
import bookstore.bims.book_api.model.Author;
import bookstore.bims.book_api.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private AuthorService service;

    @GetMapping
    public ResponseEntity<List<AuthorDTO.Response>> getAllAuthors()
    {
        List<Author> authors = service.getAllAuthors();
        return ResponseEntity.ok(Author.mapToResponse(authors));
    }

    @GetMapping("{id}")
    public ResponseEntity<AuthorDTO.Response> getAuthorById(Long id)
    {
        Author author = service.getAuthorById(id);
        return ResponseEntity.ok(Author.mapToResponse(author));
    }

    @GetMapping("name")
    public ResponseEntity<List<AuthorDTO.Response>> getAuthorByName(AuthorDTO.SearchRequest request)
    {
        List<Author> authors = service.searchAuthors(request);
        return ResponseEntity.ok(Author.mapToResponse(authors));
    }
}
