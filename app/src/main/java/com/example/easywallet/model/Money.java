package com.example.easywallet.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by RTA on 12/10/2017.
 */

public class Money {

    public  final int id;
    public final String picture;
    public final String detail;
    public final Integer money;

    public Money(int id, String picture, String detail, Integer money) {
        this.id = id;
        this.picture = picture;
        this.detail = detail;
        this.money = money;
    }


    public Drawable getPictureDrawable(Context context) {

        AssetManager am = context.getAssets();
        try {
            InputStream stream = am.open(picture);
            Drawable drawable = Drawable.createFromStream(stream,"");
            return  drawable;
        } catch (IOException e) {
            Log.e("Money", "Error opening file" + picture);
            e.printStackTrace();
            return null;
        }

    }

}
