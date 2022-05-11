package se.iths.webservices.tonahs.postservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.webservices.tonahs.postservice.Post;
import se.iths.webservices.tonahs.postservice.repository.PostRepository;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post findById(String id) {
        return Optional.of(postRepository.findById(id)).get()
            .orElseThrow(() -> new RuntimeException(id + "not found"));
    }
}
