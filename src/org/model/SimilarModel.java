package org.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王哲 on 2017/5/17.
 */
public class SimilarModel {
    private int userId;
    private List<BriefModel> similarList=new ArrayList<BriefModel>();
    private List<SimilarityModel> similarityModelList=new ArrayList<SimilarityModel>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<BriefModel> getSimilarList() {
        return similarList;
    }

    public void setSimilarList(List<BriefModel> similarList) {
        this.similarList = similarList;
    }

    public List<SimilarityModel> getSimilarityModelList() {
        return similarityModelList;
    }

    public void setSimilarityModelList(List<SimilarityModel> similarityModelList) {
        this.similarityModelList = similarityModelList;
    }
}
