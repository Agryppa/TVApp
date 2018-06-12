package com.example.herud.tvapp;

import android.support.v17.leanback.widget.HeaderItem;

/**
 * Created by Herud on 2018-06-12.
 */

public class MyHeader extends HeaderItem {


    private int pictureId;

    public MyHeader(long id, String name, int pictureId) {
        super(id, name);
        this.pictureId = pictureId;
    }

    public int getPictureId() {
        return pictureId;
    }
}
