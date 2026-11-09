package bookstore.bims.book_api.service;

import bookstore.bims.book_api.dto.AuthorDTO;
import bookstore.bims.book_api.model.Author;

import java.util.List;

public interface AuthorService {
    Author getAuthorById(Long id);
    List<Author> getAllAuthors();
    List<Author> searchAuthors(AuthorDTO.SearchRequest request);
}
