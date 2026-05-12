package com.movilcheck.backend.controller;

import com.movilcheck.backend.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ImportController {

    @Autowired
    private ImportService service;

    // La URL será: http://tu-servidor/api/import
    @PostMapping("/import")
    public String importar(@RequestBody List<Map<String, String>> lista) {
        service.importar(lista);
        return "Datos de celulares guardados correctamente en Azure";
    }
}
