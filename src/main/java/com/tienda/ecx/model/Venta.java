package com.tienda.ecx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor

public class Venta {
    private String id;
    private List<DetalleVenta> detalles;
    private FormaPago formaPago;
    private String metodoEntrega;
    private Cliente cliente;
    private LocalDate fecha;
    private double total;
}
