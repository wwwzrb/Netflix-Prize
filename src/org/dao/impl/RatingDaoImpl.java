package org.dao.impl;

import org.dao.RatingDao;
import org.dao.SuperDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.RatingModel;
import org.vo.MovieEntity;
import org.vo.RatingEntity;
import org.vo.UserEntity;

import java.util.List;

/**
 * Created by 王哲 on 2017/5/2.
 */
public class RatingDaoImpl extends SuperDao implements RatingDao {
    @Override
    public void insertRatings(List<RatingModel> ratings){
        Session session=getSessionFactory().openSession();
        Transaction tx=null;
        int count=0;
        try{
            tx=session.beginTransaction();
            for(RatingModel rating:ratings){
                count++;
                RatingEntity ratingEntity=new RatingEntity();
                Query query=session.createQuery("from MovieEntity where movieId=?");
                query.setParameter(0,rating.getMovieId());
                query.setMaxResults(1);
                MovieEntity movie=(MovieEntity)query.uniqueResult();
                if(movie==null){
                    System.out.println("movie null");
                }
                UserEntity user=(UserEntity)session.get(UserEntity.class,rating.getUserId());
                if(user!=null){
                    System.out.println("user exist");
                }
                else{
                    user=new UserEntity();
                    user.setUserId(rating.getUserId());
                    session.save(user);
                }
                ratingEntity.setMovie(movie);
                ratingEntity.setUser(user);
                ratingEntity.setRating(rating.getRating());
                ratingEntity.setTime(rating.getTime());
                session.save(ratingEntity);
                if(count%1000==0){
                    session.flush();
                    session.clear();
                    count%=1000;
                    System.out.println("session clear:"+count);
                }
            }
            tx.commit();//query执行后再提交事务！
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
