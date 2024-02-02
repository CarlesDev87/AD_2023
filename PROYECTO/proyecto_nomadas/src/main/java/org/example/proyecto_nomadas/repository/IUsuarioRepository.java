package org.example.proyecto_nomadas.repository;
import org.example.proyecto_nomadas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
