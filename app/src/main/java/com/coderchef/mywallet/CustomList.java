package com.coderchef.mywallet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by riajur on 9/12/2014.
 */
public class CustomList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] home_item;
    private final Integer[] imageId;
    private final int arrow_indicator;
    public CustomList(Activity context, String[] home_item, Integer[] imageId,int arrow_indicator) {
        super(context, R.layout.home_item_list, home_item);
        this.context = context;
        this.home_item = home_item;
        this.imageId = imageId;
        this.arrow_indicator= arrow_indicator;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.home_item_list, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.menuLabel);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.menuIcon);
        ImageView arr_indicator = (ImageView) rowView.findViewById(R.id.arrowIndicator);
        txtTitle.setText(home_item[position]);
        imageView.setImageResource(imageId[position]);
        arr_indicator.setImageResource(arrow_indicator);
        return rowView;
    }
}
