package com.example.cineplanet02;

public class Producto {

    String id, nombre, Stock, idcat ,precio, img;

    public Producto(String id, String nombre, String stock, String idcat, String precio, String img) {
        this.id = id;
        this.nombre = nombre;
        Stock = stock;
        this.idcat = idcat;
        this.precio = precio;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public String getIdcat() {
        return idcat;
    }

    public void setIdcat(String idcat) {
        this.idcat = idcat;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
