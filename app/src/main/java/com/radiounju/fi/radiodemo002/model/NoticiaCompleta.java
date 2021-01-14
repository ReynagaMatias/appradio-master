package com.radiounju.fi.radiodemo002.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class NoticiaCompleta implements Serializable {
    @SerializedName("parrafos")
    @Expose
    private List<Parrafo> parrafos;
    @SerializedName("audios")
    @Expose
    private List<Audio> audios;

    public NoticiaCompleta() {
    }

    public List<Parrafo> getParrafos() {
        return parrafos;
    }

    public void setParrafos(List<Parrafo> parrafos) {
        this.parrafos = parrafos;
    }

    public List<Audio> getAudios() {
        return audios;
    }

    public void setAudios(List<Audio> audios) {
        this.audios = audios;
    }
}
