package com.radiounju.fi.radiodemo002.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.radiounju.fi.radiodemo002.R;
import com.radiounju.fi.radiodemo002.model.Parrafo;

import java.util.List;

public class ListParrafoAdapter extends ArrayAdapter<Parrafo> {

    public ListParrafoAdapter(Context context, List<Parrafo> parrafos) {
        super(context, 0, parrafos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Parrafo parrafo = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_listview, parent, false);
        }
        // Lookup view for data population
        TextView tvParrafo = (TextView) convertView.findViewById(R.id.tvParrafo);
        // Populate the data into the template view using the data object
        tvParrafo.setText(parrafo.getTexto());
        // Return the completed view to render on screen
        return convertView;
    }
}