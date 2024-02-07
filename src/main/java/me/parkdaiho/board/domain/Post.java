package me.parkdaiho.board.domain;

import jakarta.persistence.*;
import lombok.*;
import me.parkdaiho.board.domain.user.User;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Post extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String contents;

    private Boolean isEnable;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void prePersist() {
        this.isEnable = true;
    }

    @Builder
    public Post(User user, String title, String contents) {
        this.user = user;
        this.title = title;
        this.contents = contents;
    }

    public Post update(String title, String contents) {
        this.title = title;
        this.contents = contents;

        return this;
    }
}
