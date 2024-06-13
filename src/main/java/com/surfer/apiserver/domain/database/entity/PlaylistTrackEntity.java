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
public class PlaylistTrackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "playlist_track_seq")
    @SequenceGenerator(allocationSize = 1, sequenceName = "playlist_track_seq" , name = "playlist_track_seq")
    @Column(name = "playlist_track_seq", nullable = false)
    private Long playlistTrackSeq;
    @CreationTimestamp
    @Column(name = "reg_name", nullable = false)
    private LocalDateTime regDate;
    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_group_seq", referencedColumnName = "playlist_group_seq", nullable = false)
    private PlaylistGroupEntity playlistGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_seq", referencedColumnName = "song_seq", nullable = false)
    private SongTestEntity songEntity;
}
