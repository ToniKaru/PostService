package se.iths.webservices.tonahs.postservice;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.webservices.tonahs.postservice.dto.PostDto;
import se.iths.webservices.tonahs.postservice.dto.PostNewDto;
import se.iths.webservices.tonahs.postservice.service.PostService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private final RabbitTemplate rabbitTemplate;
    private final PostService postService;

    public PostController(PostService postService, RabbitTemplate rabbitTemplate) {

        this.postService = postService;
        this.rabbitTemplate = rabbitTemplate;
    }


    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostNewDto postNewDto) {
        PostDto savedPost = postService.save(postNewDto);
        rabbitTemplate.convertAndSend(PostServiceApplication.EXCHANGE_NAME, PostServiceApplication.ROUTING_KEY, postNewDto); // Skicka ut meddelande till RabbitMQ
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable String id) {
        PostDto postDto = postService.findById(id);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

}
