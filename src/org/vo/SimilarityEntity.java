package org.vo;

import java.sql.Timestamp;

/**
 * Created by 王哲 on 2017/5/16.
 */
public class SimilarityEntity {
    private int id;
    private double similarity;
    private Timestamp time;
    private MovieEntity movie;
    private MovieEntity similar;

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public MovieEntity getSimilar() {
        return similar;
    }

    public void setSimilar(MovieEntity similar) {
        this.similar = similar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
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

        SimilarityEntity that = (SimilarityEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.similarity, similarity) != 0) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(similarity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
