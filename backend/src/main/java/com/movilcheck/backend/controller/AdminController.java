package com.movilcheck.backend.controller;

import com.movilcheck.backend.model.Tienda;
import com.movilcheck.backend.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private TiendaRepository tiendaRepo;

    // LISTAR: Obtener todas las empresas
    @GetMapping("/tiendas")
    public List<Tienda> listarTiendas() {
        return tiendaRepo.findAll();
    }

    // AGREGAR: Registrar una nueva empresa
    @PostMapping("/tiendas")
    public Tienda agregarTienda(@RequestBody Tienda nuevaTienda) {
        nuevaTienda.setActivo(true);
        return tiendaRepo.save(nuevaTienda);
    }

    // QUITAR/DESACTIVAR: Cambia el estado para que no aparezca en la web
    @PutMapping("/tiendas/{id}/desactivar")
    public String desactivarTienda(@PathVariable Long id) {
        Tienda t = tiendaRepo.findById(id).orElseThrow();
        t.setActivo(false);
        tiendaRepo.save(t);
        return "La empresa ha sido desactivada del monitoreo.";
    }
}
