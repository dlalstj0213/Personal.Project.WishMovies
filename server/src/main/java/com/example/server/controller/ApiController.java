package com.example.server.controller;

import com.example.server.dto.WishMovieDto;
import com.example.server.service.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class ApiController {

    private final WishListService wishListService;

    @GetMapping("/search")
    public List<WishMovieDto> search(@RequestParam String query, @RequestParam String country, @RequestParam String genre) {
        log.info("{}, {}, {}", query, country, genre);
        return wishListService.search(query, country, genre);
    }

    @PostMapping("")
    public WishMovieDto add(@RequestBody WishMovieDto wishMovieDto) {
        log.info("{}", wishMovieDto);
        return wishListService.add(wishMovieDto);
    }

    @GetMapping("/all")
    public List<WishMovieDto> findAll() {
        return wishListService.findAll();
    }

    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index) {
        wishListService.delete(index);
    }

    @PutMapping("/{index}")
    public ResponseEntity<WishMovieDto> addWatched(@PathVariable int index){
        var result = wishListService.addWatched(index);
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
