package com.lfork.a98620.lfree.goodsdetail;

import android.databinding.ObservableField;

import com.lfork.a98620.lfree.data.entity.Review;
import com.lfork.a98620.lfree.util.Config;

/**
 * Created by 98620 on 2018/6/13.
 */
public class ReviewItemViewModel{

    public final ObservableField<String> userPortraitPath = new ObservableField<>();

    public final ObservableField<String> index = new ObservableField<>();  //review id

    public final ObservableField<String> reviewerName = new ObservableField<>();

    public final ObservableField<String> content = new ObservableField<>();

    public final ObservableField<String> time = new ObservableField<>();

    private int reviewerId;


    public ReviewItemViewModel(Review review) {

        userPortraitPath.set(Config.ServerURL + "/image/" +review.getUser().getUserImagePath());
        index.set(review.getGoodsId());
        reviewerName.set(review.getUser().getUserName());
        time.set(review.getTime());
        content.set(review.getContent());
        reviewerId = review.getUser().getId();
    }
}