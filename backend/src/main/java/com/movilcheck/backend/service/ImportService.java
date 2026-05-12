package com.movilcheck.backend.service;

import com.movilcheck.backend.model.Smartphone;
import com.movilcheck.backend.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ImportService {

    @Autowired
    private SmartphoneRepository smartphoneRepo;

    public void importar(List<Map<String, String>> lista) {
        for (Map<String, String> item : lista) {
            String marca = item.get("marca");
            String modelo = item.get("modelo");

            // Buscamos si el equipo ya existe para no duplicarlo
            smartphoneRepo.findByMarcaAndModelo(marca, modelo)
                .orElseGet(() -> {
                    Smartphone s = new Smartphone();
                    s.setMarca(marca);
                    s.setModelo(modelo);
                    // Aquí el service usará los datos técnicos del scraper
                    s.setRam(Integer.parseInt(item.getOrDefault("ram", "0")));
                    s.setBateria(Integer.parseInt(item.getOrDefault("bateria", "0")));
                    return smartphoneRepo.save(s);
                });
        }
    }
}
