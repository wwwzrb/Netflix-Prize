package org.dao;

import org.model.BriefModel;
import org.model.MovieModel;

import java.util.List;

/**
 * Created by 王哲 on 2017/5/17.
 */
public interface MovieDao {
    List<BriefModel> getBriefList(int pageNow,int pageSize);
    MovieModel getMovie(int movieId);
}
