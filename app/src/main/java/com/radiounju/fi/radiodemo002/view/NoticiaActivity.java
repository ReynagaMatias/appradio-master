package com.radiounju.fi.radiodemo002.view;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.radiounju.fi.radiodemo002.R;
import com.radiounju.fi.radiodemo002.model.Noticia;
import com.radiounju.fi.radiodemo002.model.NoticiaCompleta;
import com.radiounju.fi.radiodemo002.model.Parrafo;
import com.radiounju.fi.radiodemo002.service.APIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NoticiaActivity extends AppCompatActivity {

    private Noticia noticia;
    private NoticiaCompleta noticiaCompleta;
    private TextView tvParrafos;
    private TextView tvTitulo;
    private ImageView imageFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);

        agregarToolbar();
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        imageFoto = (ImageView) findViewById(R.id.imageFoto);
        tvParrafos = (TextView) findViewById(R.id.tvParrafo);

        noticia = new Noticia();
        Bundle bundle = getIntent().getExtras();
        noticia = (Noticia) bundle.getSerializable("noticia");
        Toast.makeText(getApplicationContext(), noticia.getParrafo(), Toast.LENGTH_SHORT).show();

        tvTitulo.setText(noticia.getTitulo());
        Glide.with(this).load(noticia.getImagen()).centerCrop().into(imageFoto);
        obtenerNoticiasDelServidor();
    }

    public void obtenerNoticiasDelServidor() {

        /***********************************************************************************************/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);
        Call<NoticiaCompleta> call = apiService.getPublicaciones(noticia.getIdArticulo().toString());

        call.enqueue(new Callback<NoticiaCompleta>() {
            @Override
            public void onResponse(Call<NoticiaCompleta> call, Response<NoticiaCompleta> response) {
                noticiaCompleta = new NoticiaCompleta();
                noticiaCompleta.setParrafos(response.body().getParrafos());
                noticiaCompleta.setAudios(response.body().getAudios());
                String parrafos = "";
                for(Parrafo par : noticiaCompleta.getParrafos()) {
                    parrafos = par.getTexto() + "\r\n";
                }
                tvParrafos.setText(parrafos);
            }

            @Override
            public void onFailure(Call<NoticiaCompleta> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        /********************************************************************************************/
    }

    private void agregarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setDisplayHomeAsUpEnabled(true);
            //setTitle("");
        }
    }
}
