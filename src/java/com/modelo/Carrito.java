
package com.modelo;

public class Carrito {
    private int item;
    private int idProducto;
    private String nombreP;
    private String descripcionP;
    private double precioP;
    private int cantidad;
    private double subtotal;

    public Carrito() {
    }

    public Carrito(int item, int idProducto, String nombreP, String descripcionP, double precioP, int cantidad, double subtotal) {
        this.item = item;
        this.idProducto = idProducto;
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.precioP = precioP;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public double getPrecioP() {
        return precioP;
    }

    public void setPrecioP(double precioP) {
        this.precioP = precioP;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
