package org.vo;

/**
 * Created by 王哲 on 2017/5/16.
 */
public class RatingEntity {
    private int id;
    private double rating;
    private Double toU;
    private Double toUcf;
    private String time;
    private MovieEntity movie;
    private UserEntity user;

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Double getToU() {
        return toU;
    }

    public void setToU(Double toU) {
        this.toU = toU;
    }

    public Double getToUcf() {
        return toUcf;
    }

    public void setToUcf(Double toUcf) {
        this.toUcf = toUcf;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RatingEntity that = (RatingEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.rating, rating) != 0) return false;
        if (toU != null ? !toU.equals(that.toU) : that.toU != null) return false;
        if (toUcf != null ? !toUcf.equals(that.toUcf) : that.toUcf != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (toU != null ? toU.hashCode() : 0);
        result = 31 * result + (toUcf != null ? toUcf.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
