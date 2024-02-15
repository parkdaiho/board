package me.parkdaiho.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.Post;
import me.parkdaiho.board.domain.user.User;
import me.parkdaiho.board.dto.post.AddPostRequest;
import me.parkdaiho.board.dto.post.PostListResponse;
import me.parkdaiho.board.dto.post.UpdatePostRequest;
import me.parkdaiho.board.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Long addPost(User user, AddPostRequest request) {
        return postRepository.save(request.toEntity(user)).getId();
    }

    public Map<String, Object> list(int page, int size) {
        Map<String, Object> result = new HashMap<>();

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        Page<Post> posts = postRepository.findAll(pageRequest);

        List<PostListResponse> list = new ArrayList<>();
        for (Post post : posts) {
            list.add(new PostListResponse(post));
        }

        result.put("count", posts.getTotalElements());
        result.put("totalPages", posts.getTotalPages());
        result.put("list", list);

        return result;
    }

    public void add27Posts(User user) {
        for (int i = 0; i < 27; i++) {
            Post post = Post.builder()
                    .title("제목 " + i)
                    .contents("내용 " + i)
                    .user(user)
                    .build();

            postRepository.save(post);
        }
    }

    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected post"));
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

        if (!post.getUser().getId().equals(user.getId())) {
            throw new IllegalArgumentException("No authorization");
        }
    }
}
