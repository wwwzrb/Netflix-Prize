package org.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.model.RatingModel;
import org.vo.MovieEntity;

/**
 * Created by 王哲 on 2017/5/2.
 */
public class fileStream {
    File file;
    private List<MovieEntity> movies=new ArrayList<>();
   private List<RatingModel> ratings=new ArrayList<>();

    private void parseMovie(String str){
        MovieEntity movie=new MovieEntity();
        int id,date;
        String title;
        String genre;
        String[] strArray=null;
        strArray=str.split("\"");
        if(strArray.length==1){
            strArray=str.split(",");
            id=Integer.valueOf(strArray[0]);
            title=strArray[1].substring(0,strArray[1].length()-7);
            date=getDate(strArray[1]);
            genre=strArray[2];
        }
        else{
            String[] strArray1=null;
            String[] strArray2=null;
            String[] strArray3=null;
            strArray1=strArray[0].split(",");
            id= Integer.valueOf(strArray1[0]);
            strArray2=strArray[1].split(",");
            title=strArray2[0];
            date=getDate(strArray[1]);
            strArray3=strArray[2].split(",");
            genre=strArray3[strArray3.length-1];
        }
        movie.setMovieId(id);
        movie.setDate(date);
        movie.setTitle(title);
        movie.setGenre(genre);
        movies.add(movie);
    }
    private void parseRating(String str){
        RatingModel rating=new RatingModel();
        String[] strArray=null;
        strArray=str.split(",");
        rating.setUserId(getInteger(strArray[0]));
        rating.setMovieId(getInteger(strArray[1]));
        rating.setRating(Float.parseFloat(strArray[2]));
        rating.setTime(strArray[3]);
        ratings.add(rating);
    }
    private int getDate(String str){
        String reg = "\\d{4,}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            return Integer.valueOf(matcher.group());
        }
        else{
            return 0;
        }
    }
    private int getInteger(String str){
        return Integer.valueOf(str);
    }

    public List<MovieEntity> getMovies(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while (true) {
                String str = reader.readLine();
                if (str == null) {
                    break;
                }
                parseMovie(str);
            }
            reader.close();
            return movies;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<RatingModel> getRatings(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str=reader.readLine();
            while (true) {
                str = reader.readLine();
                if (str == null) {
                    break;
                }
                parseRating(str);
            }
            reader.close();
            return ratings;
        }
        catch (Exception e){
            e.printStackTrace();;
            return null;
        }
    }


}
