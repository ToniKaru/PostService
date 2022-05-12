package se.iths.webservices.tonahs.postservice.services;

import se.iths.webservices.tonahs.postservice.dto.PostDto;
import se.iths.webservices.tonahs.postservice.dto.PostNewDto;

public interface PostService {

    PostDto save(PostNewDto postNewDto);

    PostDto findById(String id);
}
