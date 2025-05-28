package com.tienda.ecx.service;
import com.tienda.ecx.model.Proveedor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProveedorService {
    private final List<Proveedor> proveedores = new ArrayList<>();
    public List<Proveedor> getAll() { return proveedores; }
    public Proveedor add(Proveedor p) { proveedores.add(p); return p; }

}
