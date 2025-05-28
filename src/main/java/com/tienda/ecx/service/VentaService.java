package com.tienda.ecx.service;
import com.tienda.ecx.model.Venta;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class VentaService {
    private final List<Venta> ventas = new ArrayList<>();
    public List<Venta> getAll() { return ventas; }
    public Venta add(Venta v) { ventas.add(v); return v; }

}

