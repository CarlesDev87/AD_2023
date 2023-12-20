package org.simarro.service;

import org.simarro.model.Producto;
import org.simarro.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private IProductoRepository repo;

    @Override
    public Producto registrar(Producto producto) {
        return repo.save(producto);
    }

    @Override
    public Producto modificar(Producto producto) {
        return repo.save(producto);
    }

    @Override
    public List<Producto> listar() {
        return repo.findAll();
    }

    @Override
    public Producto listarPorId(Integer id) {
        Optional<Producto> op = repo.findById(id);
        return op.isPresent() ? op.get(): new Producto();
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<Producto> listarPorCategoria(String categoria) {
        return repo.listarPorCategoria(categoria);
    }

    @Override
    public List<Producto> listarPorFecha(LocalDate fecha1, LocalDate fecha2) {
        return repo.listarPorFecha(fecha1, fecha2);
    }
}
