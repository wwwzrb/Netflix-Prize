package org.vo;

/**
 * Created by 王哲 on 2017/5/2.
 */
public class MovieEntity {
    private int id;
    private int movieId;
    private String title;
    private String rawPlots;
    private Integer date;
    private String genre;

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

    public String getRawPlots() {
        return rawPlots;
    }

    public void setRawPlots(String rawPlots) {
        this.rawPlots = rawPlots;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieEntity that = (MovieEntity) o;

        if (id != that.id) return false;
        if (movieId != that.movieId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (rawPlots != null ? !rawPlots.equals(that.rawPlots) : that.rawPlots != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (genre != null ? !genre.equals(that.genre) : that.genre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + movieId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (rawPlots != null ? rawPlots.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }
}
