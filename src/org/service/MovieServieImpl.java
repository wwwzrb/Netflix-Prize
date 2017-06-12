package org.service;

import org.dao.MovieDao;
import org.model.BriefModel;
import org.model.MovieModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 王哲 on 2017/5/17.
 */
@Service
public class MovieServieImpl implements MovieService {

    @Resource
    private MovieDao movieDao;

    @Override
    public List<BriefModel> getBriefList(int pageNow,int pageSize){
        return movieDao.getBriefList(pageNow,pageSize);
    }

    @Override
    public MovieModel getMovie(int movieId) {
        return movieDao.getMovie(movieId);
    }
}
