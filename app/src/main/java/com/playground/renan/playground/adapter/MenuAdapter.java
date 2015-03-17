package com.playground.renan.playground.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.playground.renan.playground.R;
import com.playground.renan.playground.pojo.MenuItem;

import java.util.List;

/**
 * Created by renan on 2/26/15.
 */
public class MenuAdapter extends ArrayAdapter<MenuItem> {

    private int resource;

    public MenuAdapter(Context context, int resource, List<MenuItem> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        MenuItem item = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resource, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.icon.setImageDrawable(getContext().getResources().getDrawable(item.getIcon()));
        holder.label.setText(getContext().getResources().getString(item.getLabel()));

        return convertView;
    }

    class Holder {
        ImageView icon;
        TextView label;

        public Holder(View v){
            icon = (ImageView) v.findViewById(R.id.item_img);
            label = (TextView) v.findViewById(R.id.item_txt_name);
        }

    }
}
