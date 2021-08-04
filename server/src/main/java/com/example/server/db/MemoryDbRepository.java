package com.example.server.db;

import java.util.List;
import java.util.Optional;

interface MemoryDbRepository<T> {
    Optional<T> findById(int index);

    T save(T entity);

    void deleteById(int index);

    List<T> findAll();
}
