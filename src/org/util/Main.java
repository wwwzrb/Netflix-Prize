package org.util;


import org.dao.RatingDao;
import org.dao.impl.MovieDaoImpl;
import org.dao.impl.RatingDaoImpl;
import org.model.RatingModel;
import org.vo.MovieEntity;
import org.dao.MovieDao;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 王哲 on 2017/5/2.
 */
public class Main {

    public static void main(final String[] args) throws Exception {
        fileStream stream=new fileStream();
        stream.file=new File("ratings.csv");
        /*List<MovieEntity> movies=stream.getMovies();
        MovieDao movieDao=new MovieDaoImpl();
        movieDao.insertMovies(movies);
        */

        MovieDao movieDao=new MovieDaoImpl();
        for(int i=1;i<=244;i++){
            movieDao.updatePlot(i);
        }



        /*
        List<RatingModel> ratings=stream.getRatings();
        RatingDao ratingDao=new RatingDaoImpl();
        ratingDao.insertRatings(ratings);
        */
    }
}