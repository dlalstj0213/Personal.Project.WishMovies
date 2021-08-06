package com.example.server.service;

import com.example.server.dto.WishMovieDto;
import com.example.server.naver.NaverClient;
import com.example.server.naver.dto.ImageSearchReq;
import com.example.server.naver.dto.MovieSearchReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;

    public WishMovieDto search(String query) {
        //영화 검색
        var movieSearchReq = new MovieSearchReq();
        movieSearchReq.setQuery(query);

        var movieSearchRes = naverClient.searchMovies(movieSearchReq);

        if (movieSearchRes.getItems().size() > 0) {
            var movieItem = movieSearchRes.getItems().stream().findFirst().get();
            // 이미지 검색
            // 이미지 검색은 후에 해당 영화 관련 이미지 포스팅을 위한 기능이기 때문에 나중에 추가하자.
            /*
            var imageQuery = movieItem.getTitle().replaceAll("<[^>]*>", "");
            var imageSearchReq = new ImageSearchReq();
            imageSearchReq.setQuery(imageQuery);

            var imageSearchRes = naverClient.searchImages(imageSearchReq);

            if (imageSearchRes.getTotal() > 0) {
                var imageItem = imageSearchRes.getItems().stream().findFirst().get();
                //결과물 리턴
                var result = new WishMovieDto();
                result.setTitle(movieItem.getTitle());

            }
             */

            // 결과물 리턴
            var result = new WishMovieDto();
            result.setTitle(movieItem.getTitle());
            result.setSubtitle(movieItem.getSubtitle());
            result.setLink(movieItem.getLink());
            result.setImage(movieItem.getImage());
            result.setPubDate(movieItem.getPubDate());
            result.setDirector(movieItem.getDirector());
            result.setActor(movieItem.getActor());
            result.setUserRating(movieItem.getUserRating());

            return result;
        }

        return new WishMovieDto();
    }
}
