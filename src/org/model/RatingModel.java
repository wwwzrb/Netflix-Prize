package org.model;

/**
 * Created by 王哲 on 2017/5/17.
 */
public class RatingModel {
    private  int movieId;
    private int userId;
    private double rating;
    private Double toU;
    private Double toUcf;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
