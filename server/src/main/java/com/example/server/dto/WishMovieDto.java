package com.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishMovieDto {
    private Integer index;
    private String title;
    private String subtitle;
    private String link;
    private String image;
    private Date pubDate;
    private String director;
    private String actor;
    private float userRating;
    private boolean isWatched;
    private int watchCount;

/**
 * WishMovieDto와 WishMovieEntity로 분리한 이유:
 * 데이터베이스의 엔터티 클래스를 변경하게 되면 프론트엔드까지 영향을 끼치기 때문에
 * 중간에 변환하는 과정을 할 수 있는 DTO로 따로 클래스를 정의했다.
 */

}
