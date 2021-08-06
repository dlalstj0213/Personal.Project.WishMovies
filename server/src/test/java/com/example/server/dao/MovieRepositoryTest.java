package com.example.server.dao;

import com.example.server.entity.WishMovieEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    private WishMovieEntity create() {
        var wishMoviesEntity = new WishMovieEntity();
        wishMoviesEntity.setTitle("title");
        wishMoviesEntity.setSubtitle("subTitle");
        wishMoviesEntity.setLink("");
        wishMoviesEntity.setImage("");
        wishMoviesEntity.setPubDate(new Date());
        wishMoviesEntity.setDirector("director name");
        wishMoviesEntity.setActor("actor1|actor2|");
        wishMoviesEntity.setUserRating(4.50F);
        return wishMoviesEntity;
    }

    @Test
    public void saveTest() {
        var wishMoviesEntity = create();
        var expected = movieRepository.save(wishMoviesEntity);

        // 반환된 객체가 Null이면 안되기 때문에 Null인지 테스트
        Assertions.assertNotNull(expected);
        // 저장 후 index 값이 제대로 입력 되었는지 테스트
        Assertions.assertEquals(movieRepository.findAll().size(), expected.getIndex());
    }

    @Test
    public void updateTest() {
        var wishMoviesEntity = create();
        var expected = movieRepository.save(wishMoviesEntity);

        expected.setTitle("update title");
        var updated = movieRepository.save(expected);

        Assertions.assertEquals("update title", updated.getTitle());
        //Assertions.assertEquals(1, movieRepository.findAll().size());
    }

    @Test
    public void findByIdTest() {
        var wishMoviesEntity = create();
        movieRepository.save(wishMoviesEntity);

        var expected = movieRepository.findById(1);

        // Optional은 Null이 오지 않기 때문에 안의 데이터가 있는지를 테스트
        Assertions.assertEquals(true, expected.isPresent());
        // 장상적인 인덱스의 값으로 찾아온건지 테스트
        Assertions.assertEquals(1, expected.get().getIndex());
        System.out.println(expected.get());
    }

    @Test
    public void deleteByIdTest() {
        var wishMoviesEntity = create();
        movieRepository.save(wishMoviesEntity);

        movieRepository.deleteById(1);

        int count = movieRepository.findAll().size();

        // 데이터 하나를 저장 후 그 데이터를 삭제한다음 0의 결과값을 기대하는 테스트
        Assertions.assertEquals(0, count);
    }

    @Test
    public void findAllTest() {
//        var wishMoviesEntity1 = create();
//        movieRepository.save(wishMoviesEntity1);
//        var wishMoviesEntity2 = create();
//        movieRepository.save(wishMoviesEntity2);

        int count = movieRepository.findAll().size();
        movieRepository.findAll().stream().forEach(movie -> {
            System.out.println(movie);
            System.out.println("index: " + movie.getIndex());
        });
        //Assertions.assertEquals(2, count);
    }
}
