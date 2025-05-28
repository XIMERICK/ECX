package com.tienda.ecx.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class FormaPago {
    public FormaPago(tipoPago efectivo, estadoPago pendiente) {

    }

    private String tipoPago;
    private String estadoPago;
    public char[] generarRecibo() {
        throw new UnsupportedOperationException("Unimplemented method 'generarRecibo'");
    }
}
