package com.carlamo.adt6_practica1.repository;

import com.carlamo.adt6_practica1.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVueloRepository  extends JpaRepository<Vuelo, Integer> {
}
