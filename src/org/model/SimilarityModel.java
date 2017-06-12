package org.model;

/**
 * Created by 王哲 on 2017/5/17.
 */
public class SimilarityModel {
    private int movieId;
    private int similarId;
    private double similarity;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getSimilarId() {
        return similarId;
    }

    public void setSimilarId(int similarId) {
        this.similarId = similarId;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }
}
