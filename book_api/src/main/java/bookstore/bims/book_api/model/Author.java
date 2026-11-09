package bookstore.bims.book_api.model;

import bookstore.bims.book_api.dto.AuthorDTO;
import bookstore.bims.book_api.dto.BookDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author", schema = "book", uniqueConstraints = {
    @UniqueConstraint(name = "unique_author",columnNames = {"first_name", "last_name"})
})

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;

    @NotBlank
    @Size(min =2, max = 255)
    @Column(name = "fist_name")
    private String firstName;

    @NotBlank
    @Size(min =2, max = 255)
    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books;

    public static AuthorDTO.Summary mapToSummary(Author author)
    {
        return new AuthorDTO.Summary(
                author.getId(),
                author.getFirstName(),
                author.getLastName()
        );
    }

    public static AuthorDTO.Response mapToResponse(Author author)
    {
        Set<BookDTO.Summary> bookSummaries = new HashSet<>();

        return new AuthorDTO.Response(
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                BookDTO.mapToSummary(author.getBooks())
        );
    }

    public static List<AuthorDTO.Response> mapToResponse(List<Author> authors)
    {
        List<AuthorDTO.Response> responses = new ArrayList<>();
        for(Author a : authors)
        {
            responses.add(mapToResponse(a));
        }

        return responses;
    }
}
