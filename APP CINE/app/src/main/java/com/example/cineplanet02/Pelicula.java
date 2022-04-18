package com.example.cineplanet02;

public class Pelicula {
    private String id, imageurl, titulo, genero, clasi, duracion, videoid, estreno, sinopsis;

    public Pelicula(String id, String titulo, String genero, String clasi, String duracion, String imageurl, String videoid, String estreno, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.clasi = clasi;
        this.duracion = duracion;
        this.imageurl = imageurl;
        this.videoid = videoid;
        this.estreno = estreno;
        this.sinopsis = sinopsis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }


    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasi() {
        return clasi;
    }

    public void setClasi(String clasi) {
        this.clasi = clasi;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getVideoid() {
        return videoid;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }

    public String getEstreno() {
        return estreno;
    }

    public void setEstreno(String estreno) {
        this.estreno = estreno;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

}
