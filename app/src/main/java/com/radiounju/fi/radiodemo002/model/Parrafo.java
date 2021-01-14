package com.radiounju.fi.radiodemo002.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Parrafo implements Serializable {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("idArticulo")
    @Expose
    private String idArticulo;
    @SerializedName("texto")
    @Expose
    private String texto;
    @SerializedName("fechaPublicacion")
    @Expose
    private String fechaPublicacion;

    public Parrafo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
