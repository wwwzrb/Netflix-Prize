package org.dao.impl;

import com.google.gson.Gson;
import org.dao.MovieDao;
import org.dao.SuperDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.MovieModel;
import org.model.ResponseModel;
import org.model.UrlModel;
import org.util.okHttpUtil;
import org.vo.MovieEntity;

import java.util.List;

/**
 * Created by 王哲 on 2017/3/30.
 */
public class MovieDaoImpl extends SuperDao implements MovieDao {

    @Override
    public MovieEntity getMovie(int movieId){
        Session session=getSessionFactory().openSession();
        Transaction tx=null;
        MovieEntity movie=new MovieEntity();
        try{
            tx=session.beginTransaction();
            Query query=session.createQuery("from UserEntity where userId=?");
            query.setParameter(0,movieId);
            query.setMaxResults(1);
            movie=(MovieEntity)query.uniqueResult();
            tx.commit();
            return movie;
        }
        catch(Exception e){
            if(tx!=null)
                tx.rollback();;
            e.printStackTrace();
        }finally {
            {
                session.close();
            }
        }
        return movie;
    }
    @Override
    public void insertMovies(List<MovieEntity> movies){
        Session session=getSessionFactory().openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            for(MovieEntity movie:movies){
                session.save(movie);
            }
            tx.commit();
        }
        catch(Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            {
                session.close();
            }
        }
    }
    @Override
    public void updateMovie(int id){
        Session session=getSessionFactory().openSession();
        Transaction tx=null;
        MovieEntity movie;
        try{
            tx=session.beginTransaction();
            movie=session.get(MovieEntity.class,id);
            UrlModel url=new UrlModel();
            url.setT(movie.getTitle());
            String y=movie.getDate().toString();
            System.out.println(y);
            url.setY(y);
            okHttpUtil httpUtil=new okHttpUtil();
            Gson gson=new Gson();
            try{
                System.out.println(url.toString());
                String result=httpUtil.get(url.toString());
                System.out.println(result);
                ResponseModel responseModel=gson.fromJson(result, ResponseModel.class);
                if(!responseModel.getResponse().equals("False")) {
                    MovieModel movieModel=gson.fromJson(result,MovieModel.class);
                    movie.setReleased(movieModel.getReleased());
                    movie.setDirector(movieModel.getDirector());
                    movie.setWriter(movieModel.getWriter());
                    movie.setActors(movieModel.getActors());
                    movie.setShortPlot(movieModel.getPlot());
                    movie.setLanguage(movieModel.getLanguage());
                    movie.setCountry(movieModel.getCountry());
                    movie.setPoster(movieModel.getPoster());
                    movie.setImdbRating(movieModel.getImdbRating());
                    movie.setImdbVotes(movieModel.getImdbVotes());
                    movie.setImdbId(movieModel.getImdbID());
                }
                session.update(movie);
            }catch (Exception e){
                e.printStackTrace();
            }
            tx.commit();
        }
        catch(Exception e){
            if(tx!=null)
                tx.rollback();;
            e.printStackTrace();
        }finally {
            {
                session.close();
            }
        }
    }

}
