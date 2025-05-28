package com.tienda.ecx.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Location extends Parameter {
    public Location(String code, String description) {
        super(code, description);
    }

    @Override
    public Object getId(){
        return this.getCode();
    }


}
