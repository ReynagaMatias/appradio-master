package com.radiounju.fi.radiodemo002.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Audio implements Serializable {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("idArticulo")
    @Expose
    private String idArticulo;
    @SerializedName("idFrame")
    @Expose
    private String idFrame;
    @SerializedName("srcEstilo")
    @Expose
    private String srcEstilo;
    @SerializedName("linkAudio")
    @Expose
    private String linkAudio;
    @SerializedName("titulo")
    @Expose
    private String titulo;
    @SerializedName("linkMP3")
    @Expose
    private String linkMP3;

    public Audio() {
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

    public String getIdFrame() {
        return idFrame;
    }

    public void setIdFrame(String idFrame) {
        this.idFrame = idFrame;
    }

    public String getSrcEstilo() {
        return srcEstilo;
    }

    public void setSrcEstilo(String srcEstilo) {
        this.srcEstilo = srcEstilo;
    }

    public String getLinkAudio() {
        return linkAudio;
    }

    public void setLinkAudio(String linkAudio) {
        this.linkAudio = linkAudio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLinkMP3() {
        return linkMP3;
    }

    public void setLinkMP3(String linkMP3) {
        this.linkMP3 = linkMP3;
    }
}
