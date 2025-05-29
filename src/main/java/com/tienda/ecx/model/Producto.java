package com.tienda.ecx.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private Proveedor proveedor;
    private Categoria categoria;

    public Producto(String id, String nombre, double precio, int cantidad, String proveedor, Categoria categoria) {
    }
}

