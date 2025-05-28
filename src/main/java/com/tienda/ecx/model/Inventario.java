package com.tienda.ecx.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Inventario {
    private Producto producto;
    private int cantidad;

}
