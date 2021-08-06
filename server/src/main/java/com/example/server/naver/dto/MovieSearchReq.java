package com.example.server.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieSearchReq {
    private String query = "";      //Y
    private int display = 10;       //N
    private int start = 1;          //N
    private String genre = "";      //N
    private String country = "";    //N
    private int yearFrom = 0;       //N
    private int yearTo = 0;         //N

    public MultiValueMap<String, String> toMultiValueMap() {
        var map = new LinkedMultiValueMap<String, String>();
        map.add("query", query);
        if (display != 0) map.add("display", String.valueOf(display));
        if (start != 0) map.add("start", String.valueOf(start));
        if (!"".equals(genre)) map.add("genre", genre);
        if (!"".equals(country)) map.add("country", country);
        if (yearFrom != 0) map.add("yearFrom", String.valueOf(yearFrom));
        if (yearTo != 0) map.add("yearTo", String.valueOf(yearTo));
        return map;
    }
}
