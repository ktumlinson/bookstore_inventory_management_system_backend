package bookstore.bims.book_api.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String message,
        LocalDateTime timestamp
) {
    public ErrorResponse(int status, String message, LocalDateTime timestamp)
    {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
