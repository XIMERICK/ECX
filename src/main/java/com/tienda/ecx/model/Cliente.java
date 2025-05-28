package com.tienda.ecx.model

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.stream.Location;

@Getter
@Setter
@AllArgsConstructor

public class Cliente {
    private String nombre;
    private String id;
    private String telefono;
    private Location city;

}
