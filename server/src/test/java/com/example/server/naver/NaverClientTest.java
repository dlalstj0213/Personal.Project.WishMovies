package com.example.server.naver;

import com.example.server.naver.dto.ImageSearchReq;
import com.example.server.naver.dto.MovieSearchReq;
import com.example.server.naver.dto.MovieSearchRes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaverClientTest {

    @Autowired
    private NaverClient naverClient;

    @Test
    public void searchMoviesTest() {
        var search = new MovieSearchReq();

        search.setQuery("베테랑");
        search.setCountry("KR");

        var result = naverClient.searchMovies(search);
        System.out.println(result);
    }

    @Test
    public void searchImageTest() {
        var search = new ImageSearchReq();

        search.setQuery("베테랑");

        var result = naverClient.searchImages(search);
        System.out.println(result);
    }

}
