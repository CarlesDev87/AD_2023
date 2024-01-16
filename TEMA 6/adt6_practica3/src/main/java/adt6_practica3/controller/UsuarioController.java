package adt6_practica3.controller;


import adt6_practica3.model.Usuario;
import adt6_practica3.model.dto.UsuarioRequestDto;
import adt6_practica3.model.dto.UsuarioResponseDto;
import adt6_practica3.service.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;


    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> busquedaConcreta(@PathVariable Integer id) {
        UsuarioResponseDto usuarioDTO = service.buscarPorId(id);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> buscarTodos() {
        List<UsuarioResponseDto> usuarioDTO = service.buscarTodos();
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }

   @PostMapping
    public ResponseEntity<Usuario> insertar(@Valid @RequestBody UsuarioRequestDto usuario) {
        Usuario user = service.insertar(usuario);
        return new ResponseEntity<>(user, HttpStatus.OK);
   }

   @PutMapping("/{id}")
    public ResponseEntity<Usuario> modificar(@RequestBody UsuarioRequestDto usuarioRequestDto, @PathVariable ("id") Integer id) {
        Usuario usuarioDTO = service.modificar(usuarioRequestDto,id);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
   }






}
