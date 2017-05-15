package org.vo;

/**
 * Created by 王哲 on 2017/5/15.
 */
public class MovieEntity {
    private int id;
    private int movieId;
    private String title;
    private Integer date;
    private String genre;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieEntity that = (MovieEntity) o;

        if (id != that.id) return false;
        if (movieId != that.movieId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (genre != null ? !genre.equals(that.genre) : that.genre != null) return false;
        if (released != null ? !released.equals(that.released) : that.released != null) return false;
        if (director != null ? !director.equals(that.director) : that.director != null) return false;
        if (writer != null ? !writer.equals(that.writer) : that.writer != null) return false;
        if (actors != null ? !actors.equals(that.actors) : that.actors != null) return false;
        if (shortPlot != null ? !shortPlot.equals(that.shortPlot) : that.shortPlot != null) return false;
        if (rawPlot != null ? !rawPlot.equals(that.rawPlot) : that.rawPlot != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (poster != null ? !poster.equals(that.poster) : that.poster != null) return false;
        if (imdbRating != null ? !imdbRating.equals(that.imdbRating) : that.imdbRating != null) return false;
        if (imdbVotes != null ? !imdbVotes.equals(that.imdbVotes) : that.imdbVotes != null) return false;
        if (imdbId != null ? !imdbId.equals(that.imdbId) : that.imdbId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + movieId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (released != null ? released.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (writer != null ? writer.hashCode() : 0);
        result = 31 * result + (actors != null ? actors.hashCode() : 0);
        result = 31 * result + (shortPlot != null ? shortPlot.hashCode() : 0);
        result = 31 * result + (rawPlot != null ? rawPlot.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        result = 31 * result + (imdbRating != null ? imdbRating.hashCode() : 0);
        result = 31 * result + (imdbVotes != null ? imdbVotes.hashCode() : 0);
        result = 31 * result + (imdbId != null ? imdbId.hashCode() : 0);
        return result;
    }
}
