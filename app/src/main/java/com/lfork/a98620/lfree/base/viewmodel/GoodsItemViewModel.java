package com.lfork.a98620.lfree.base.viewmodel;

import android.content.Context;
import android.content.Intent;

import com.lfork.a98620.lfree.data.entity.Goods;
import com.lfork.a98620.lfree.goodsdetail.GoodsDetailActivity;
import com.lfork.a98620.lfree.util.Config;

import java.lang.ref.WeakReference;

/**
 * Created by 98620 on 2018/4/14.
 */

public class GoodsItemViewModel extends GoodsViewModel {

    private WeakReference<Context> reference;

    public GoodsItemViewModel(Context context, Goods g) {
        super(context, g.getId());
        name.set(g.getName());
        price.set(g.getPrice() + "元");
        imagePath.set(Config.ServerURL + "/image" + g.getCoverImagePath() ); //
        publishDate.set(g.getPublishDate());
        setCategoryId(g.getCategoryId());
        reference = new WeakReference<>(context);
    }

    public void onClick(){

        if (reference != null && reference.get() != null) {
            Intent intent = new Intent(context, GoodsDetailActivity.class);
            intent.putExtra("goods_id", getId());
            intent.putExtra("category_id", getCategoryId());
            reference .get().startActivity(intent);
        }
    }
}
