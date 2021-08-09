package com.example.server.service;

import com.example.server.dao.MovieRepository;
import com.example.server.dto.WishMovieDto;
import com.example.server.entity.WishMovieEntity;
import com.example.server.naver.NaverClient;
import com.example.server.naver.dto.ImageSearchReq;
import com.example.server.naver.dto.MovieSearchReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;
    private final MovieRepository movieRepository;

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

    public WishMovieDto add(WishMovieDto wishMovieDto) {
        var entity = dtoToEntity(wishMovieDto);
        return entityToDto(movieRepository.save(entity));
    }

    public List<WishMovieDto> findAll() {
        return movieRepository.findAll().stream().map(movie -> entityToDto(movie)).collect(Collectors.toList());
    }

    public void delete(int index) {
        movieRepository.deleteById(index);
    }

    public WishMovieDto addWatched(int index) {
        var movieItem = movieRepository.findById(index);
        if (movieItem.isPresent()) {
            var item = movieItem.get();

            item.setWatched(true);
            item.setWatchCount(item.getWatchCount()+1);
            return entityToDto(item);
        }
        return null;
    }

    private WishMovieDto entityToDto(WishMovieEntity wishMovieEntity) {
        var dto = new WishMovieDto();
        dto.setIndex(wishMovieEntity.getIndex());
        dto.setTitle(wishMovieEntity.getTitle());
        dto.setSubtitle(wishMovieEntity.getSubtitle());
        dto.setLink(wishMovieEntity.getLink());
        dto.setImage(wishMovieEntity.getImage());
        dto.setPubDate(wishMovieEntity.getPubDate());
        dto.setDirector(wishMovieEntity.getDirector());
        dto.setActor(wishMovieEntity.getActor());
        dto.setUserRating(wishMovieEntity.getUserRating());
        dto.setWatched(wishMovieEntity.isWatched());
        dto.setWatchCount(wishMovieEntity.getWatchCount());
        return dto;
    }

    private WishMovieEntity dtoToEntity(WishMovieDto wishMovieDto) {
        var entity = new WishMovieEntity();
        entity.setIndex(wishMovieDto.getIndex());
        entity.setTitle(wishMovieDto.getTitle());
        entity.setSubtitle(wishMovieDto.getSubtitle());
        entity.setLink(wishMovieDto.getLink());
        entity.setImage(wishMovieDto.getImage());
        entity.setPubDate(wishMovieDto.getPubDate());
        entity.setDirector(wishMovieDto.getDirector());
        entity.setActor(wishMovieDto.getActor());
        entity.setUserRating(wishMovieDto.getUserRating());
        entity.setWatched(wishMovieDto.isWatched());
        entity.setWatchCount(wishMovieDto.getWatchCount());
        return entity;
    }


}
