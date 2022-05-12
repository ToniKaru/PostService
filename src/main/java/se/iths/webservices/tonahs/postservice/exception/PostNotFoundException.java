package se.iths.webservices.tonahs.postservice.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String id) {
        super("Post id " + id + " not found.");
    }
}
