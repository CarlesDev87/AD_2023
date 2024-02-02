package org.example.proyecto_nomadas.repository;
import org.example.proyecto_nomadas.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {
}
