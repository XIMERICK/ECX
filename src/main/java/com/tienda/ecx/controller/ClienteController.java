package com.tienda.ecx.controller;

import com.tienda.ecx.model.Cliente;
import com.tienda.ecx.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService service;
    public ClienteController(ClienteService service) { this.service = service; }

    @GetMapping
    public List<Cliente> getAll() { return service.getAll(); }
    @PostMapping
    public Cliente add(@RequestBody Cliente c) { return service.add(c); }

}
