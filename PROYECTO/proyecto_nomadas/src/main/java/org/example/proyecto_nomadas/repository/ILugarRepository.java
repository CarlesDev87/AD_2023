package org.example.proyecto_nomadas.repository;
import org.example.proyecto_nomadas.model.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILugarRepository extends JpaRepository<Lugar, Integer> {
}
