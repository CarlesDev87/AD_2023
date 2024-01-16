package adt6_practica3.service;

import adt6_practica3.model.Usuario;
import adt6_practica3.model.dto.UsuarioRequestDto;
import adt6_practica3.model.dto.UsuarioResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUsuarioService {


    List<UsuarioResponseDto> buscarTodos();

    UsuarioResponseDto buscarPorId(Integer id);

    Usuario insertar(UsuarioRequestDto usuario);

    public Usuario modificar(UsuarioRequestDto usuarioRequestDto, Integer id);

}
