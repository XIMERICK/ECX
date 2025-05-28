package com.tienda.ecx.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Proveedor {
    private String id;
    private String razonSocial;
    private String direccion;
    private String telefono;
}
