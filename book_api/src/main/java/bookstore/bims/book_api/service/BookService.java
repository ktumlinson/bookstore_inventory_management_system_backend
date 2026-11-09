package bookstore.bims.book_api.service;

import bookstore.bims.book_api.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
}
