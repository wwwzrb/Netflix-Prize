package org.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 王哲 on 2017/5/17.
 */
public class UserEntity {
    private int userId;
    private Timestamp time;
    private Set<RatingEntity> ratings=new HashSet<>();
    private Set<CfratingEntity> cfratings=new HashSet<>();

    public Set<RatingEntity> getRatings() {
        return ratings;
    }

    public void setRatings(Set<RatingEntity> ratings) {
        this.ratings = ratings;
    }

    public Set<CfratingEntity> getCfratings() {
        return cfratings;
    }

    public void setCfratings(Set<CfratingEntity> cfratings) {
        this.cfratings = cfratings;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
