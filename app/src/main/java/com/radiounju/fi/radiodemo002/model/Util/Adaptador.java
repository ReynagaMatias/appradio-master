package com.radiounju.fi.radiodemo002.model.Util;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.radiounju.fi.radiodemo002.R;
import com.radiounju.fi.radiodemo002.model.Noticia;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adaptador extends BaseAdapter {
    private Context context;
    private List<Noticia> listNoticias;

    public Adaptador(Context context, List<Noticia> listNoticias){
        this.context = context;
        this.listNoticias = listNoticias;
    }

    @Override
    public int getCount() {
        return listNoticias.size();
    }

    @Override
    public Object getItem(int position) {
        return listNoticias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Noticia noticia = listNoticias.get(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.row_item,null);
        ImageView image = (ImageView)convertView.findViewById(R.id.imagen);
        TextView title = (TextView)convertView.findViewById(R.id.tvTitulo);
        TextView introduccion = (TextView)convertView.findViewById(R.id.tvParrafo);
        TextView date = (TextView)convertView.findViewById(R.id.tvFecha);
        ImageView imageIcon = (ImageView)convertView.findViewById(R.id.imgIcon);
        Picasso.get().load(noticia.getImagen()).into(image);
        //image.setImageResource(R.drawable.play);
        title.setText(noticia.getTitulo().toString());
        introduccion.setText(Html.fromHtml(noticia.getParrafo()));
        date.setText(noticia.getFechaPublicacion().toString());
        //imageIcon.setImageResource(R.drawable.play);
        return convertView;
    }
}
