package org.dao;

import org.vo.MovieEntity;

import java.util.List;

/**
 * Created by 王哲 on 2017/3/29.
 */

public interface MovieDao {
    MovieEntity getMovie(int movieId);
    void insertMovies(List<MovieEntity> movies);
    void updateMovie(int id);
}
