package org.simarro.controller;

import org.simarro.model.Producto;
import org.simarro.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl service;

    @GetMapping
    public List<Producto> listar() {
        return service.listar();

    }
    @GetMapping("/{id}")
    public Producto listarPorId(@PathVariable("id") Integer id) {
        return service.listarPorId(id);
    }

    @PostMapping
    public Producto registrar(@RequestBody Producto p) {
        return service.registrar(p);
    }
    @PutMapping
    public Producto modificar(@RequestBody Producto p) {
        return service.modificar(p);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
    }

    @GetMapping("/buscar")
    public List<Producto> listarPorCategoria(@RequestParam(value="categoria") String categoria) {
        return service.listarPorCategoria(categoria);
    }


}
