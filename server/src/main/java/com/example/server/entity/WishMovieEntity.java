package com.example.server.entity;

import com.example.server.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishMovieEntity extends MemoryDbEntity implements Serializable{
    private String title;
    private String subtitle;
    private String link;
    private String image;
    private Date pubDate;
    private String director;
    private String actor;
    private float userRating;
}
