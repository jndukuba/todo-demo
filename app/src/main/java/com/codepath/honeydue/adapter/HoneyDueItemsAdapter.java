package com.codepath.honeydue.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.codepath.honeydue.R;
import com.codepath.honeydue.storage.HoneyDueItem;

import java.util.List;

/**
 * Created by jndukuba on 9/3/17.
 */

public class HoneyDueItemsAdapter extends ArrayAdapter<HoneyDueItem> {

    public HoneyDueItemsAdapter(Context context, List<HoneyDueItem> items ) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        HoneyDueItem item = getItem(position);

        if( convertView == null ) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_honey_due, parent, false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.nameTextView);

        nameTextView.setText(item.getName());

        return convertView;

    }

}