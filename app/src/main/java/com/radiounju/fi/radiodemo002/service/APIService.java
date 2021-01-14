package com.radiounju.fi.radiodemo002.service;

import com.radiounju.fi.radiodemo002.model.Audio;
import com.radiounju.fi.radiodemo002.model.Noticia;
import com.radiounju.fi.radiodemo002.model.NoticiaCompleta;
import com.radiounju.fi.radiodemo002.model.Parrafo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;

public interface APIService {

    String BASE_URL = "http://backendradio.000webhostapp.com/endpoints/";
    //String BASE_URL = "http://192.168.1.2/radioUNJu/endpoints/";

    @Headers("Content-Type: application/json")
    @GET("noticias.php")
    Call<List<Noticia>> getNoticias();

    @Headers("Content-Type: application/json")
    @GET("parrafoaudio.php?")
    Call<NoticiaCompleta> getPublicaciones(@Query("idArticulo") String idArticulo);

    @Headers("Content-Type: application/json")
    @GET("radioUNJu/endpoints/parrafos.php")
    Call<List<Parrafo>> getParrafos();
    @Headers("Content-Type: application/json")
    @GET("radioUNJu/endpoints/audios.php")
    Call<List<Audio>> getAudios();
}
