package com.movilcheck.backend.repository;

import com.movilcheck.backend.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
    // Este método nos servirá para que el Scraper de las 2 AM 
    // no duplique celulares que ya existen.
    Optional<Smartphone> findByMarcaAndModelo(String marca, String modelo);
}
