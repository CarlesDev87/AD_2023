package com.carlamo.adt6_practica1.repository;

import com.carlamo.adt6_practica1.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVueloRepository extends JpaRepository<Vuelo, Integer> {

    @Modifying // esta anotación le dice a la query que va a modificar datos en la BBDD
    @Query("FROM Vuelo v WHERE v.destino LIKE %:destino%")
    List<Vuelo> borrarPorDestino(@Param("destino") String destino);

/*
    @Query("FROM Vuelo v WHERE v.origen AND v.destino AND v.numeroEscalas LIKE :origen AND :destino AND :numeroEscalas")
    List<Vuelo> filtrarPorAtributos(@Param("origen") String origen,
                                    @Param("destino") String destino,
                                    @Param("numeroEcalas") Integer numeroEscalas);
 */

}
