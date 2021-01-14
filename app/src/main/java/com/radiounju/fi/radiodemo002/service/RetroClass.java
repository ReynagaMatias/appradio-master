package com.radiounju.fi.radiodemo002.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {
    private static final String BASEURL="https://ruserver.000webhostapp.com/endpoints/";
    private static Retrofit getRetrofitInstance()
    {
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    public static APIService getAPIService()
    {
        return getRetrofitInstance().create(APIService.class);
    }
}
