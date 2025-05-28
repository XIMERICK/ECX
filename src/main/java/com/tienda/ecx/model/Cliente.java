package com.tienda.ecx.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Cliente {
    private String nombre;
    private String id;
    private String telefono;
    private Location city;
}
