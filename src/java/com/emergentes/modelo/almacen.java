
package com.emergentes.modelo;

public class almacen {
    private int id;
    private String producto;
    private int precio;
    private int cantidad;
    
    public almacen() {
        id = 0;
        producto = "";
        precio = 0;
        cantidad = 0;
    }

    public almacen(int id, String producto, int precio, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    
}
