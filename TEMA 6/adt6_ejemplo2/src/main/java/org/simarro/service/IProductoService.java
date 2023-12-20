package org.simarro.service;

import org.simarro.model.Producto;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public interface IProductoService {

    Producto registrar(Producto producto);
    Producto modificar(Producto producto);
    List<Producto> listar();
    Producto listarPorId(Integer id);
    void eliminar(Integer id);
    List<Producto> listarPorCategoria(String categoria);
    List<Producto> listarPorFecha(LocalDate fecha1, LocalDate fecha2);
}
