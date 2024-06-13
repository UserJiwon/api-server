package com.surfer.apiserver.domain.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistLikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "playlist_like_seq")
    @SequenceGenerator(allocationSize = 1, sequenceName = "playlist_like_seq" , name = "playlist_like_seq")
    @Column(name = "playlit_like_seq", nullable = false)
    private Long playlistLikeSeq;
    @CreationTimestamp
    @Column(name = "reg_date", nullable = false)
    private LocalDateTime regDate;
    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_group_seq", referencedColumnName = "playlist_group_seq", nullable = false)
    private PlaylistGroupEntity playlistGroupEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id", nullable = false)
    private MemberEntity memberEntity;
}
