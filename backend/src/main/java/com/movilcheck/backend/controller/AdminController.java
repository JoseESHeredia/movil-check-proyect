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

    // LISTAR EMPRESAS
    @GetMapping("/tiendas")
    public List<Tienda> listar() {
        return tiendaRepo.findAll();
    }

    // AGREGAR EMPRESA (Claro, Entel, etc.)
    @PostMapping("/tiendas")
    public Tienda agregar(@RequestBody Tienda tienda) {
        tienda.setActivo(true);
        return tiendaRepo.save(tienda);
    }

    // QUITAR/ELIMINAR EMPRESA
    @DeleteMapping("/tiendas/{id}")
    public void eliminar(@PathVariable Long id) {
        tiendaRepo.deleteById(id);
    }
}
