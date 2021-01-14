package com.radiounju.fi.radiodemo002.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Noticia implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("idArticulo")
    @Expose
    private String idArticulo;
    @SerializedName("imagen")
    @Expose
    private String imagen;
    @SerializedName("linkNoticia")
    @Expose
    private String linkNoticia;
    @SerializedName("titulo")
    @Expose
    private String titulo;
    @SerializedName("categoria")
    @Expose
    private String categoria;
    @SerializedName("autor")
    @Expose
    private String autor;
    @SerializedName("parrafo")
    @Expose
    private String parrafo;
    @SerializedName("fechaPublicacion")
    @Expose
    private String fechaPublicacion;
    @SerializedName("parrafos")
    @Expose
    private List<Parrafo> parrafos;
    @SerializedName("audios")
    @Expose
    private List<Audio> audios;

    public Noticia() {
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getLinkNoticia() {
        return linkNoticia;
    }

    public void setLinkNoticia(String linkNoticia) {
        this.linkNoticia = linkNoticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getParrafo() {
        return parrafo;
    }

    public void setParrafo(String parrafo) {
        this.parrafo = parrafo;
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

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "id=" + id +
                ", idArticulo='" + idArticulo + '\'' +
                ", imagen='" + imagen + '\'' +
                ", linkNoticia='" + linkNoticia + '\'' +
                ", titulo='" + titulo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", autor='" + autor + '\'' +
                ", parrafo='" + parrafo + '\'' +
                ", parrafos=" + parrafos +
                ", audios=" + audios +
                '}';
    }
}
