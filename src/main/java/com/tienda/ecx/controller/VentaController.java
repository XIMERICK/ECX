package com.tienda.ecx.controller;
import com.tienda.ecx.model.Venta;
import com.tienda.ecx.service.VentaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    private final VentaService service;
    public VentaController(VentaService service) { this.service = service; }

    @GetMapping
    public List<Venta> getAll() { return service.getAll(); }
    @PostMapping
    public Venta add(@RequestBody Venta v) { return service.add(v); }

}
