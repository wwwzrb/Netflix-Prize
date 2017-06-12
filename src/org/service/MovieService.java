package org.service;

import org.model.BriefModel;
import org.model.MovieModel;

import java.util.List;

/**
 * Created by 王哲 on 2017/5/17.
 */
public interface MovieService {
    List<BriefModel> getBriefList(int pageNow,int pageSize);
    MovieModel getMovie(int movieId);
}
