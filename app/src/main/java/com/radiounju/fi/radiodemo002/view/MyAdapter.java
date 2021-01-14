package com.radiounju.fi.radiodemo002.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.radiounju.fi.radiodemo002.R;
import com.radiounju.fi.radiodemo002.model.Noticia;

import java.util.List;

/**
 * Created by anupamchugh on 05/10/16.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Noticia> noticiaList;
    private Context context;

    public MyAdapter(List<Noticia> noticiaList, Context context) {
        this.noticiaList = noticiaList;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Noticia noticia = noticiaList.get(position);
        holder.txtTitulo.setText(noticia.getTitulo());
        holder.txtParrafo.setText(noticia.getParrafo());
        holder.txtFechaPublicacion.setText(noticia.getFechaPublicacion());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), NoticiaActivity.class);
                Bundle bundleUser = new Bundle();
                bundleUser.putSerializable("noticia", noticia);
                intent.putExtras(bundleUser);
                context.startActivity(intent);
            }
        });
        Glide.with(context).load(noticia.getImagen()).centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return noticiaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtTitulo;
        public TextView txtParrafo;
        public TextView txtFechaPublicacion;
        public ImageView imageView;
        //public ClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            this.txtTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            this.txtParrafo = (TextView) itemView.findViewById(R.id.tvParrafo);
            this.txtFechaPublicacion = (TextView) itemView.findViewById(R.id.tvFecha);
            this.imageView = (ImageView) itemView.findViewById(R.id.imagen);
        }

    }
}
