package bookstore.bims.book_api.dto;

public class PublisherDTO {
    public record SearchRequest(
            String publisherName
    ){}

    public record CreateRequest(
            String publisherName
    ){}

    public record Response(
            Long id,
            String publisherName
    ){}
}
