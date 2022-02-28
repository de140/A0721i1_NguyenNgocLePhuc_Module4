package com.codegym.repository;

import com.codegym.model.Music;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    void update(Music music);
}