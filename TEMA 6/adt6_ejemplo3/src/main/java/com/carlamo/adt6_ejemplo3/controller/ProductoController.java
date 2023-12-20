package com.carlamo.adt6_ejemplo3.controller;

import com.carlamo.adt6_ejemplo3.model.Producto;
import com.carlamo.adt6_ejemplo3.service.ProductoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {

      //  return service.listar();

        List<Producto> lista = service.listar();

        if (lista.isEmpty()) {

            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);

        } else {

            return new ResponseEntity<>(lista, HttpStatus.OK);

        }

    }
    @GetMapping("/{id}")
    public Producto listarPorId(@PathVariable("id") Integer id) {

            // return service.listarPorId(id);

        Producto obj= service.listarPorId(id);

        if (obj == null) {

            return new ResponseEntity<>(obj, HttpStatus.NO_CONTENT).getBody();

        } else {

            return new ResponseEntity<>(obj, HttpStatus.OK).getBody();

        }
    }

    @PostMapping
    public Producto registrar(@Valid @RequestBody Producto p) {
        return service.registrar(p);
    }
    @PutMapping
    public Producto modificar(@Valid @RequestBody Producto p) {
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
