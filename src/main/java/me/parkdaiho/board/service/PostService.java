package me.parkdaiho.board.service;

import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.Post;
import me.parkdaiho.board.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Post writePost(WritePostRequest dto) {
        return postRepository.save(Post.builder()
                .userId(dto.getUserId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build());
    }

    public List<Post> postList() {
        List<Post> posts = postRepository.findAll();

        return posts;
    }
}
