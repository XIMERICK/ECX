package com.tienda.ecx.service;

import com.opencsv.CSVReader;
import com.tienda.ecx.model.Cliente;
import com.tienda.ecx.model.Location;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Getter
public class ClienteService {

    private List<Cliente> clientes;

    @Value("${cliente_filename}")
    private String clienteFilename;

    private final LocationService locationService;

    public ClienteService(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostConstruct
    public void init() {
        clientes = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(clienteFilename))))) {

            List<String[]> lines = reader.readAll();
            lines.remove(0);

            for (String[] line : lines) {
                String nombre = line[0];
                String id = line[1];
                String telefono = line[2];
                String cityId = line[3];

                Location city = locationService.getLocations().stream()
                        .filter(loc -> loc.getId().equals(cityId))
                        .findFirst()
                        .orElse(null);

                Cliente cliente = new Cliente(nombre, id, telefono, city);
                clientes.add(cliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> getAll() {
        return clientes;
    }

    public Cliente add(Cliente c) {
        return c;
    }
}

