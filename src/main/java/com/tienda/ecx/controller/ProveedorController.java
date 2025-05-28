package com.tienda.ecx.controller;

import com.tienda.ecx.model.Proveedor;
import com.tienda.ecx.service.ProveedorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService service;
    public ProveedorController(ProveedorService service) { this.service = service; }

    @GetMapping
    public List<Proveedor> getAll() { return service.getAll(); }
    @PostMapping
    public Proveedor add(@RequestBody Proveedor p) { return service.add(p); }

}
