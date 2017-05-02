package org.dao.impl;

import org.dao.SuperDao;
import org.dao.UserDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.vo.UserEntity;

/**
 * Created by 王哲 on 2017/5/2.
 */
public class UserDaoImpl extends SuperDao implements UserDao{
    @Override
    public UserEntity getUser(int userId){
        Session session=getSessionFactory().openSession();
        Transaction tx=null;
        UserEntity user=new UserEntity();
        try{
            tx=session.beginTransaction();
            user=session.get(UserEntity.class,userId);
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
        return user;
    }

    @Override
    public void updateUser(int userId){
        Session session=getSessionFactory().openSession();
        Transaction tx=null;
        UserEntity user=null;
        try{
            tx=session.beginTransaction();
            user=session.get(UserEntity.class,userId);
            if(user!=null)
                return;
            else{
                user=new UserEntity();
                user.setUserId(userId);
                session.save(user);
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
