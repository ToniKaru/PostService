package se.iths.webservices.tonahs.postservice.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.webservices.tonahs.postservice.Post;
import se.iths.webservices.tonahs.postservice.dto.PostDto;
import se.iths.webservices.tonahs.postservice.dto.PostNewDto;
import se.iths.webservices.tonahs.postservice.exception.PostNotFoundException;
import se.iths.webservices.tonahs.postservice.repository.PostRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;

    @Autowired
    PostServiceImpl (PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public PostDto save(PostNewDto postNewDto) {
        Post post = new Post();
        post.setText(postNewDto.getText());
        post.setUserId(postNewDto.getUserId());
        post.setParentId(postNewDto.getParentId());

        post = postRepository.save(post);

        return getPostDto(post);
    }



    @Override
    public PostDto findById(String id) {
        if (id == null){
            throw new IllegalArgumentException("PostId must not be null");
        }

        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isEmpty()){
            throw new PostNotFoundException(id);
        }
        Post post = postOptional.get();

        return getPostDto(post);

    }

    private Date getCreated(String id) {
        var mongoId = new ObjectId(id);
        return mongoId.getDate();
    }

    private PostDto getPostDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setText(post.getText());
        postDto.setUserId(post.getUserId());
        postDto.setParentId(post.getParentId());
        postDto.setCreated(getCreated(post.getId()));
        return postDto;
    }
}
