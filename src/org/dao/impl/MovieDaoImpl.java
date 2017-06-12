package org.dao.impl;

import org.dao.MovieDao;
import org.dao.SuperDao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.*;
import org.springframework.stereotype.Repository;
import org.vo.MovieEntity;
import org.vo.RatingEntity;
import org.vo.SimilarityEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王哲 on 2017/5/17.
 */
@Repository
public class MovieDaoImpl extends SuperDao implements MovieDao{

    @Override
    public List<BriefModel> getBriefList(int pageNow,int pageSize){
        Session session=this.getSessionFactory().openSession();
        Transaction tx=null;
        List<BriefModel> briefModelList=new ArrayList<BriefModel>();
        try{
            tx=session.beginTransaction();
            Query query=session.createQuery("from MovieEntity where (movieId between 1 and 244) order by date desc");
            query.setFirstResult((pageNow-1)*pageSize);
            query.setMaxResults(pageSize);
            List<MovieEntity> movieList=query.list();
            for(MovieEntity movie:movieList){
                BriefModel briefModel=new BriefModel();
                briefModel.setMovieId(movie.getMovieId());
                briefModel.setTitle(movie.getTitle());
                briefModel.setActors(movie.getActors());
                briefModel.setDirector(movie.getDirector());
                briefModel.setPoster(movie.getPoster());
                briefModel.setReleased(movie.getReleased());
                briefModel.setShortPlot(movie.getShortPlot());
                briefModel.setGenre(movie.getGenre());
                briefModelList.add(briefModel);
            }
            tx.commit();
        }
        catch (Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
        return briefModelList;
    }

    @Override
    public MovieModel getMovie(int movieId){
        Session session=this.getSessionFactory().openSession();
        Transaction tx=null;
        MovieModel movieModel=new MovieModel();
        int count=0;
        try{
            tx=session.beginTransaction();
            MovieEntity movieEntity=session.get(MovieEntity.class,movieId);
            if(movieEntity==null)
            {
                System.out.print("????");
                return movieModel;
            }
            movieModel.setMovieId(movieEntity.getMovieId());
            movieModel.setTitle(movieEntity.getTitle());
            movieModel.setGenre(movieEntity.getGenre());
            movieModel.setActors(movieEntity.getActors());
            movieModel.setCountry(movieEntity.getCountry());
            movieModel.setDate(movieEntity.getDate());
            movieModel.setDirector(movieEntity.getDirector());
            movieModel.setReleased(movieEntity.getReleased());
            movieModel.setShortPlot(movieEntity.getRawPlot());
            movieModel.setLanguage(movieEntity.getLanguage());
            movieModel.setPoster(movieEntity.getPoster());
            movieModel.setImdbRating(movieEntity.getImdbRating());
            movieModel.setImdbVotes(movieEntity.getImdbVotes());
            movieModel.setImdbId(movieEntity.getImdbId());

            for(RatingEntity rating:movieEntity.getRatings()){
                RatingModel ratingModel=new RatingModel();
                ratingModel.setMovieId(movieEntity.getMovieId());
                ratingModel.setUserId(rating.getUser().getUserId());
                ratingModel.setRating(rating.getRating());
                ratingModel.setToU(rating.getToU());
                ratingModel.setToUcf(rating.getToUcf());
                movieModel.getRatingModelList().add(ratingModel);
                count++;
            }


            Query queryColdId=session.createQuery("from MovieEntity where(movieId between 1 and 244) order by date desc");
            queryColdId.setMaxResults(20);
            List<MovieEntity> movieEntityList=queryColdId.list();
            List<Integer> coldIdList=new ArrayList<Integer>();
            for(MovieEntity movie:movieEntityList){
                coldIdList.add(movie.getMovieId());
            }//get Cold Start MovieList


            for(RatingModel ratingModel:movieModel.getRatingModelList()){
                Query queryMovieId=session.createQuery("from RatingEntity where user.userId=? and movie.movieId not in (:movieIds)");
                queryMovieId.setParameter(0,ratingModel.getUserId());
                queryMovieId.setParameter("movieIds",coldIdList);
                List<RatingEntity> ratingEntityList=queryMovieId.list();
                List<Integer> movieIdList=new ArrayList<Integer>();
                for(RatingEntity rating:ratingEntityList){
                    movieIdList.add(rating.getMovie().getMovieId());
                }
                Query queryTou=session.createQuery("from SimilarityEntity where movie.movieId=? and similar.movieId in (:movieIds) order by similarity desc ");
                queryTou.setParameter(0,movieModel.getMovieId());
                queryTou.setParameter("movieIds",movieIdList);
                queryTou.setMaxResults(3);
                List<SimilarityEntity> similarityEntityList=queryTou.getResultList();
                SimilarModel similarModel=new SimilarModel();
                similarModel.setUserId(ratingModel.getUserId());
                for(SimilarityEntity similarity:similarityEntityList){
                   SimilarityModel similarityModel=new SimilarityModel();
                   similarityModel.setMovieId(movieModel.getMovieId());
                   similarityModel.setSimilarId(similarity.getSimilar().getMovieId());
                   similarityModel.setSimilarity(similarity.getSimilarity());
                   similarModel.getSimilarityModelList().add(similarityModel);
                   BriefModel briefModel=new BriefModel();
                   briefModel.setMovieId(similarity.getSimilar().getMovieId());
                   briefModel.setTitle(similarity.getSimilar().getTitle());
                   briefModel.setGenre(similarity.getSimilar().getGenre());
                   briefModel.setPoster(similarity.getSimilar().getPoster());
                   briefModel.setReleased(similarity.getSimilar().getReleased());
                   briefModel.setDirector(similarity.getSimilar().getDirector());
                   briefModel.setActors(similarity.getSimilar().getActors());
                   similarModel.getSimilarList().add(briefModel);
                }
                movieModel.getSimilarModelList().add(similarModel);
            }//get ToU movieList


            Query queryToa=session.createQuery("from SimilarityEntity where movie.movieId=? and similar.movieId not in (:movieIds) order by similarity desc ");
            queryToa.setParameter(0,movieModel.getMovieId());
            queryToa.setParameter("movieIds",coldIdList);
            queryToa.setMaxResults(6);
            List<SimilarityEntity> similarityEntityList=queryToa.getResultList();
            for(SimilarityEntity similarity:similarityEntityList){
                BriefModel briefModel=new BriefModel();
                briefModel.setMovieId(similarity.getSimilar().getMovieId());
                briefModel.setTitle(similarity.getSimilar().getTitle());
                briefModel.setGenre(similarity.getSimilar().getGenre());
                briefModel.setPoster(similarity.getSimilar().getPoster());
                briefModel.setReleased(similarity.getSimilar().getReleased());
                briefModel.setDirector(similarity.getSimilar().getDirector());
                briefModel.setActors(similarity.getSimilar().getActors());
                movieModel.getBriefModelList().add(briefModel);
            }

            tx.commit();
        }
        catch (Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
        return movieModel;
    }

}
