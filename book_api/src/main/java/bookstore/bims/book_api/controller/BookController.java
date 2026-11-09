package bookstore.bims.book_api.controller;

import bookstore.bims.book_api.dto.BookDTO;
import bookstore.bims.book_api.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private BookService service;

    @GetMapping
    public ResponseEntity<List<BookDTO.Response>> getAllBooks()
    {

        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDTO.Response> getBookByTitle(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.getBookById(id));
    }
}
