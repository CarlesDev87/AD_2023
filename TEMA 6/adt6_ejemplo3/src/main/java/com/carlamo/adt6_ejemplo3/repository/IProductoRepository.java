package com.carlamo.adt6_ejemplo3.repository;

import com.carlamo.adt6_ejemplo3.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {


    // Métodos específicos de esta entidad diferentes al CRUD mediante JPQL
    @Query("FROM Producto p WHERE LOWER(p.categoria) LIKE %:categoria%")
    List<Producto> listarPorCategoria(@Param("categoria") String categoria);
    // >= 03/02/2024 <04/02/2024
    @Query("FROM Producto p WHERE p.fechaCreacion BETWEEN :fecha1 AND :fecha2")
    List<Producto> listarPorFecha(@Param("fecha1") LocalDate fecha1,
                                  @Param("fecha2") LocalDate fecha2);

}
