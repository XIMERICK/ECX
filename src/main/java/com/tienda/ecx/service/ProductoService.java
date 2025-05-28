package com.tienda.ecx.service;

import com.opencsv.CSVReader;
import com.tienda.ecx.model.Categoria;
import com.tienda.ecx.model.Producto;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Getter
public class ProductoService {

    private static final Logger log = LoggerFactory.getLogger(ProductoService.class);

    private final CategoriaService categoriaService;
    private List<Producto> productos;

    @Value("${producto_filename}")
    private String productoFilename;

    private final LocationService locationService;

    public ProductoService(LocationService locationService, CategoriaService categoriaService) {
        this.locationService = locationService;
        this.categoriaService = categoriaService;
    }

    @PostConstruct
    public void init() {
        productos = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(productoFilename))))) {

            List<String[]> lines = reader.readAll();
            lines.removeFirst();

            for (String[] line : lines) {
                if (line.length < 6) {
                    log.warn("Línea de CSV incompleta, saltando: {}", String.join(",", line));
                    continue;
                }

                String id = line[0];
                String nombre = line[1];
                double precio = Double.parseDouble(line[2]);
                int cantidad = Integer.parseInt(line[3]);
                String proveedor = line[4];
                String categoriaId = line[5];

                Optional<Categoria> optionalCategoria = categoriaService.getAll().stream() // Asumiendo que getCategorias() devuelve List<Categoria>
                        .filter(cat -> cat.getId().equals(categoriaId))
                        .findFirst();

                Categoria categoria = optionalCategoria.orElse(null);

                if (categoria == null) {
                    log.warn("Categoría con ID {} no encontrada para el producto {}. El producto se añadirá sin categoría.", categoriaId, nombre);
                }

                Producto producto = new Producto(id, nombre, precio, cantidad, proveedor, categoria);

                productos.add(producto);
            }

        } catch (Exception e) {
            log.error("Error al cargar productos desde el archivo CSV: {}", productoFilename, e);
        }
    }
}
