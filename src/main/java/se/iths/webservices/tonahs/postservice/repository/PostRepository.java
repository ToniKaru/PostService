package se.iths.webservices.tonahs.postservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.iths.webservices.tonahs.postservice.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
