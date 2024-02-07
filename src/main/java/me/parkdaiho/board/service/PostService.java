package me.parkdaiho.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.Post;
import me.parkdaiho.board.domain.user.User;
import me.parkdaiho.board.dto.AddPostRequest;
import me.parkdaiho.board.dto.PostViewResponse;
import me.parkdaiho.board.dto.UpdatePostRequest;
import me.parkdaiho.board.repository.PostRepository;
import me.parkdaiho.board.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Long addPost(AddPostRequest dto, User user) {
        return postRepository.save(dto.toEntity(user)).getId();
    }

    public PostViewResponse findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected post"));

        return new PostViewResponse(post);
    }

    @Transactional
    public void deletePostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected post"));

        authorization(post);
        postRepository.delete(post);
    }

    @Transactional
    public Long updatePostById(Long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected post"));

        authorization(post);

        post.update(request.getTitle(), request.getContents());

        return post.getId();
    }

    private static void authorization(Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(!post.getUser().getId().equals(user.getId())) {
            throw new IllegalArgumentException("check writer");
        }
    }
}
