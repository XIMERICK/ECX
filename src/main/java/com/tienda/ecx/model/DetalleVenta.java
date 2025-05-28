package com.tienda.ecx.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class DetalleVenta {
    private int idDetalleVenta;
    private Producto Producto;
    private byte cantidad;
    private double precioUnitario;
    private double subTotal;
    private double totalPagar;
}
