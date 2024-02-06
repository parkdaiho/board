package me.parkdaiho.board.service;

import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.Post;
import me.parkdaiho.board.dto.AddPostRequest;
import me.parkdaiho.board.repository.PostRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Long addPost(AddPostRequest dto) {
        return postRepository.save(dto.toEntity()).getId();
    }

    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected post"));
    }
}
