package com.example.server.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageSearchRes {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<ImageSearchItems> items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImageSearchItems {
        private String title;
        private String link;
        private String thumbnail;
        private String sizeheight;
        private String sizewidth;
    }
}
