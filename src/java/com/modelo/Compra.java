
package com.modelo;

import java.util.List;

public class Compra {
    private int idCompra; //auto-incrementable
    private int idUsuario; // clave foranea
    private String tipoPago; // pendiente creacion de su tabla
    private double total;
    private String fecha;
    private String nroSerie;
    private double costoEnvio;
    private List<Carrito> carrito;
    private String usuNombre;
    private String usuApellido;
    
    public Compra() {
    }

    public Compra(int idCompra, int idUsuario, String tipoPago, double total, String fecha, String nroSerie, double costoEnvio, List<Carrito> carrito, String usuNombre, String usuApellido) {
        this.idCompra = idCompra;
        this.idUsuario = idUsuario;
        this.tipoPago = tipoPago;
        this.total = total;
        this.fecha = fecha;
        this.nroSerie = nroSerie;
        this.costoEnvio = costoEnvio;
        this.carrito = carrito;
        this.usuNombre = usuNombre;
        this.usuApellido = usuApellido;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }
    public double getCostoEnvio() {
        return costoEnvio;
    }
    public void setCostoEnvio(double costoEnvio){
        this.costoEnvio = costoEnvio; 
    }
    public List<Carrito> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Carrito> carrito) {
        this.carrito = carrito;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }
    
    
}
