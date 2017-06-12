package org.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王哲 on 2017/5/17.
 */
public class MovieModel {
    private int movieId;
    private String title;
    private String released;
    private String director;
    private String writer;
    private String actors;
    private String shortPlot;
    private String rawPlot;
    private String language;
    private String country;
    private String poster;
    private String imdbRating;
    private String imdbVotes;
    private String imdbId;
    private String genre;
    private Integer date;
    private List<RatingModel> ratingModelList=new ArrayList<RatingModel>();
    private List<SimilarModel> similarModelList=new ArrayList<SimilarModel>();
    private List<BriefModel> briefModelList=new ArrayList<BriefModel>();

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getShortPlot() {
        return shortPlot;
    }

    public void setShortPlot(String shortPlot) {
        this.shortPlot = shortPlot;
    }

    public String getRawPlot() {
        return rawPlot;
    }

    public void setRawPlot(String rawPlot) {
        this.rawPlot = rawPlot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public List<RatingModel> getRatingModelList() {
        return ratingModelList;
    }

    public void setRatingModelList(List<RatingModel> ratingModelList) {
        this.ratingModelList = ratingModelList;
    }

    public List<SimilarModel> getSimilarModelList() {
        return similarModelList;
    }

    public void setSimilarModelList(List<SimilarModel> similarModelList) {
        this.similarModelList = similarModelList;
    }

    public List<BriefModel> getBriefModelList() {
        return briefModelList;
    }

    public void setBriefModelList(List<BriefModel> briefModelList) {
        this.briefModelList = briefModelList;
    }
}
