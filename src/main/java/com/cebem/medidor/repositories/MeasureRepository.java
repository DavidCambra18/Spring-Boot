package com.cebem.medidor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cebem.medidor.models.Measure;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Long> {
    // Aquí puedes agregar métodos personalizados si lo necesitas
}