package bookstore.bims.book_api.service.impl;

import bookstore.bims.book_api.dto.AuthorDTO;
import bookstore.bims.book_api.exception.ResourceNotFoundException;
import bookstore.bims.book_api.model.Author;
import bookstore.bims.book_api.repository.AuthorRepository;
import bookstore.bims.book_api.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository repository;

    @Override
    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Could not find author with id: " + id));
    }

    @Override
    public List<Author> searchAuthors(AuthorDTO.SearchRequest request) throws ResourceNotFoundException
    {
        if(request.firstName() != null && request.lastName() != null)
        {
            return getAuthorsByFirstNameLastName(request.firstName(), request.lastName());
        }
        else if(request.firstName() != null)
        {
            return getAuthorsByFirstName(request.firstName());
        }
        else if(request.lastName() != null)
        {
            return getAuthorsByLastName(request.lastName());
        }

        throw(new ResourceNotFoundException("Unable to find requested Author"));
    }

    private List<Author> getAuthorsByLastName(String name) {
        return repository.findByLastName(name);
    }

    private List<Author> getAuthorsByFirstName(String name) {
        return repository.findByFirstName(name);
    }

    private List<Author> getAuthorsByFirstNameLastName(String firstName, String lastName) {
        return repository.findByFirstNameAndLastName(firstName, lastName);
    }
}
