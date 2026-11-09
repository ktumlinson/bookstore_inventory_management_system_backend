package bookstore.bims.book_api.service.impl;

import bookstore.bims.book_api.dto.BookDTO;
import bookstore.bims.book_api.model.Book;
import bookstore.bims.book_api.repository.BookRepository;
import bookstore.bims.book_api.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = repository.findAll();
        List<BookDTO> bookDtos = new ArrayList<>();
        for (Book b : books)
        {


        }
        return List.of();
    }

    @Override
    public BookDTO getBookById(Long id) {
        return null;
    }
}
