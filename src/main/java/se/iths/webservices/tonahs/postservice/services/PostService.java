package se.iths.webservices.tonahs.postservice.services;

import se.iths.webservices.tonahs.postservice.Post;

public interface PostService {

    Post save(Post post);

    Post findById(String id);
}
