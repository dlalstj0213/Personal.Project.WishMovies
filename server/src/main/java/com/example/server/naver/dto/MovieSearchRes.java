package com.example.server.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieSearchRes {
    private String lastBuildDate;
    private List<MovieSearchItem> items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MovieSearchItem {
        private String title;
        private String link;
        private String image;
        private String subtitle;
        private Date pubDate;
        private String director;
        private String actor;
        private float userRating;
    }
}
