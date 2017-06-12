package org.action;

import com.opensymphony.xwork2.ActionContext;
import org.model.BriefModel;
import org.model.MovieModel;
import org.service.MovieService;
import org.springframework.stereotype.Controller;
import org.tool.Num;
import org.tool.Pager;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * Created by 王哲 on 2017/5/17.
 */
@Controller
public class MovieAction {

    private int pageNow=1;
    private int pageSize=4;
    private int movieId;

    @Resource
    private MovieService movieService;

    public String getBriefList(){
        Map session = ActionContext.getContext().getSession();
        List<BriefModel> breifList=movieService.getBriefList(this.getPageNow(),this.getPageSize());
        Pager pager=new Pager(this.getPageNow(),20);
        List<Num> nums=new ArrayList<Num>();
        int length=20/this.getPageSize()+1;
        for(int i=1;i<length;i++)
        {
            Num num=new Num();
            num.setNumber(i);
            if(this.getPageNow()%length==i){
                num.setNow(true);
            }
            else
                num.setNow(false);
            nums.add(num);
        }
        session.put("nums",nums);
        session.put("page",pager);
        session.put("briefList",breifList);
        return SUCCESS;
    }

    public String getMovie(){
        Map session = ActionContext.getContext().getSession();
        MovieModel movie=movieService.getMovie(this.getMovieId());
        session.put("movie",movie);
        return SUCCESS;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
