package me.parkdaiho.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.Post;
import me.parkdaiho.board.domain.user.User;
import me.parkdaiho.board.dto.AddPostRequest;
import me.parkdaiho.board.dto.PostListResponse;
import me.parkdaiho.board.dto.PostViewResponse;
import me.parkdaiho.board.dto.UpdatePostRequest;
import me.parkdaiho.board.repository.PostRepository;
import me.parkdaiho.board.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Long addPost(AddPostRequest dto, User user) {
        return postRepository.save(dto.toEntity(user)).getId();
    }

    public List<PostListResponse> lists(int page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Post> result = postRepository.findAll(pageRequest);

        List<PostListResponse> lists = new ArrayList<>();

        for(Post post : result.getContent()) {
            lists.add(new PostListResponse(post));
        }

        return lists;
    }

    public void add27Posts(User user) {
        for(int i = 0; i < 27; i++) {
            Post post = Post.builder()
                    .title("제목 " + i)
                    .contents("내용 " + i)
                    .user(user)
                    .build();

            postRepository.save(post);
        }
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
