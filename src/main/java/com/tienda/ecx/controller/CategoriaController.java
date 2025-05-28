package com.tienda.ecx.controller;

import com.tienda.ecx.model.Categoria;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @GetMapping
    public List<Categoria> getAll() {
        return Arrays.asList(Categoria.values());
    }

    @PostMapping
    public ResponseEntity<Categoria> agregarCategoria(@RequestBody String nombreCategoria) {
        try {
            Categoria nuevaCategoria = Categoria.valueOf(nombreCategoria.replace(" ", ""));
            return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}