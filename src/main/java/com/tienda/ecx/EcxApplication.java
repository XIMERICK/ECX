package com.tienda.ecx;

import com.tienda.ecx.model.FormaPago;
import com.tienda.ecx.model.TipoPago;
import com.tienda.ecx.model.estadoPago;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcxApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcxApplication.class, args);
    }

    public class Main {
        public static void main(String[] args) {
            FormaPago f = new FormaPago(TipoPago.efectivo, estadoPago.pendiente);
            System.out.println(f.generarRecibo());
        }
    }


}
