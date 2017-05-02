package org.dao;

import org.model.RatingModel;

import java.util.List;

/**
 * Created by 王哲 on 2017/5/2.
 */
public interface RatingDao {
    void insertRatings(List<RatingModel> ratings);
}
