package com.tienda.ecx.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public abstract class Parameter {
    private String code;
    private String description;

    public abstract Object getId();
}
