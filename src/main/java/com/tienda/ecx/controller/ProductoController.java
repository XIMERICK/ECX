package com.tienda.ecx.controller;

import com.tienda.ecx.model.Producto;
import com.tienda.ecx.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")

public class ProductoController {

    private final ProductoService service;
    public ProductoController(ProductoService service) { this.service = service; }

    @GetMapping
    public List<Producto> getAll() { return service.getAll(); }
    @PostMapping
    public Producto add(@RequestBody Producto p) { return service.add(p); }

}
