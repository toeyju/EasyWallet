package com.example.easywallet.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easywallet.R;
import com.example.easywallet.model.Money;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by RTA on 12/10/2017.
 */

public class aListAdapter extends ArrayAdapter<Money> {

    public static Object add;
    private Context mContext;
    private ArrayList<Money> aList;
    private int mLayoutResId;


    public aListAdapter(@NonNull Context context, int resource, ArrayList<Money> objects) {
        super(context, resource);
        this.mContext = context;
        this.mLayoutResId = resource;
        this.aList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(mLayoutResId, null);

        Money item = aList.get(position);



        ImageView iv = v.findViewById(R.id.imageView);
        TextView tv = v.findViewById(R.id.textView);
        TextView tv2 = v.findViewById(R.id.textView2);

        Money money = aList.get(position);

        Drawable drawable = money.getPictureDrawable(mContext);
        iv.setImageDrawable(drawable);

        tv.setText(
                String.format(
                        Locale.getDefault(),
                        "%s",
                        money.detail
                )
        );
        tv2.setText(
                String.format(
                        Locale.getDefault(),
                        "%s",
                        money.money
                )
        );
        return v;

    }
}
