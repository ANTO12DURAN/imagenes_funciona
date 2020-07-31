
package com.modelo;


public class Producto {
    private int id;
    private String codigo;
    private String nombre;
    private String ruta;
    private String descripcion;
    private double precio;
    private int stock;
    private String status;

    public Producto() {
    }

    public Producto(int id, String codigo, String nombre, String ruta, String descripcion, double precio, int stock, String status) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.ruta = ruta;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
}
