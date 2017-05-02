package org.dao;

import org.vo.UserEntity;

/**
 * Created by 王哲 on 2017/5/2.
 */
public  interface UserDao
{
    UserEntity getUser(int userId);
    void updateUser(int userId);
}
