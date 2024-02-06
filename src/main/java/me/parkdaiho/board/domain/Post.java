package me.parkdaiho.board.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Post extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false, nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String title;

    private String contents;

    private Boolean isEnable;

    @PrePersist
    public void prePersist() {
        this.isEnable = true;
    }

    @Builder
    public Post(Long userId, String title, String contents) {
        this.userId = userId;
        this.title = title;
        this.contents = contents;
    }
}
