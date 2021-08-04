package com.example.server.dao;

import com.example.server.db.MemoryDbRepositoryAbstract;
import com.example.server.entity.WishMoviesEntity;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository extends MemoryDbRepositoryAbstract<WishMoviesEntity> {
}
