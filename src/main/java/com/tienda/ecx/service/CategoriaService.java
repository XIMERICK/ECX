package com.tienda.ecx.service;

import com.tienda.ecx.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {
    private final List<Categoria> categorias = new ArrayList<>();
    public List<Categoria> getAll() { return categorias; }
    public Categoria add(Categoria c) { categorias.add(c); return c; }
}
