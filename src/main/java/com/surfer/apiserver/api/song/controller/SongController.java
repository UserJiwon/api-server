package com.surfer.apiserver.api.song.controller;

import com.surfer.apiserver.api.song.service.SongService;
import com.surfer.apiserver.common.response.ApiResponseCode;
import com.surfer.apiserver.common.response.BaseResponse;
import com.surfer.apiserver.common.response.RestApiResponse;
import com.surfer.apiserver.domain.database.entity.SongEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URL;

@RestController
@RequestMapping("/api/song")
public class SongController {

    @Autowired
    private SongService  songService;

    @GetMapping("/download/{id}")
    public ResponseEntity<String> downloadFile(@PathVariable Long id) {
        SongEntity songEntity = songService.selectById(id);
        if (songEntity == null) {
            return ResponseEntity.notFound().build();
        }
        URL downloadUrl = songService.generateSongFileUrl(songEntity.getSoundSourceName());
        return ResponseEntity.ok(downloadUrl.toString());
    }

    @GetMapping("/{songId}/like-status")
    public ResponseEntity<RestApiResponse> isLiked(@PathVariable Long songId) {
        boolean isLiked = songService.isSongLikedByUser(songId);
        return ResponseEntity.ok(new RestApiResponse(new BaseResponse(ApiResponseCode.SUCCESS), isLiked));
    }

    @PostMapping("/{songId}/like")
    public ResponseEntity<RestApiResponse> likeSong(@PathVariable Long songId) {
        songService.likeSong(songId);
        return ResponseEntity.ok(new RestApiResponse(new BaseResponse(ApiResponseCode.SUCCESS)));
    }

    @DeleteMapping("/{songId}/like")
    public ResponseEntity<RestApiResponse> unlikeSong(@PathVariable Long songId) {
        songService.unlikeSong(songId);
        return ResponseEntity.ok(new RestApiResponse(new BaseResponse(ApiResponseCode.SUCCESS)));
    }

    @GetMapping("/{songId}/like-count")
    public ResponseEntity<RestApiResponse> likeCount(@PathVariable Long songId) {
        long count = songService.countSongLikes(songId);
        return ResponseEntity.ok(new RestApiResponse(new BaseResponse(ApiResponseCode.SUCCESS), count));
    }
}
