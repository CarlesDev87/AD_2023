package com.carlamo.adt6_practica1.repository;

import com.carlamo.adt6_practica1.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IVueloRepository  extends JpaRepository<Vuelo, Integer> {
    @Query("FROM Vuelo v WHERE v.destino LIKE %:destino%")
    List<Vuelo> eliminarPorDestino(@Param("destino") String destino);


}
