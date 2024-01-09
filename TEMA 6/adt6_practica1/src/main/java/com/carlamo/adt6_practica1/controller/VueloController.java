package com.carlamo.adt6_practica1.controller;

import com.carlamo.adt6_practica1.model.Vuelo;
import com.carlamo.adt6_practica1.service.VueloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    private VueloServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Vuelo>> buscar() {
        List<Vuelo> lista = service.buscar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vuelo> registrar(@RequestBody Vuelo v) {
        Vuelo vuel = service.registrar(v);
        return new ResponseEntity<>(vuel, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Vuelo> modificar(@RequestBody Vuelo v) {
        Vuelo vue = service.modificar(v);
        return new ResponseEntity<>(vue, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/borrar/{destino}")
    public ResponseEntity<List<Vuelo>> borrarPorDestino(@RequestParam (value="destino")String destino) {
        List<Vuelo> listaVuelos = service.borrarPorDestino(destino);
        if (listaVuelos.isEmpty()) {
            return new ResponseEntity<>(listaVuelos, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(listaVuelos, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Vuelo>> search (@RequestParam(value ="origen", required = false) String origen,
                                                @RequestParam(value ="destino", required = false) String destino,
                                                @RequestParam(value ="num_escalas", required = false) Integer num_escalas)  {

            List<Vuelo> resultados = new ArrayList<>();

            List<Vuelo> allFlights = service.buscar();

        for (Vuelo flight : allFlights) {
            if (origen != null && flight.getOrigen().equals(origen)) {
                resultados.add(flight);
            } else if (destino != null && flight.getDestino().equals(destino)){
                resultados.add(flight);
            } else if (num_escalas != null && flight.getNum_escalas() == num_escalas) {
                resultados.add(flight);
            }
        }
        return new ResponseEntity<>(resultados, HttpStatus.OK);
    }
}
