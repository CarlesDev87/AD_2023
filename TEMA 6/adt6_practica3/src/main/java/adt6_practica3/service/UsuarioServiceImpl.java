package adt6_practica3.service;

import adt6_practica3.model.Usuario;
import adt6_practica3.model.dto.UsuarioRequestDto;
import adt6_practica3.model.dto.UsuarioResponseDto;
import adt6_practica3.repository.IUsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Usuario modificar(UsuarioRequestDto usuarioRequestDto, Integer id) {
        Usuario user = modelMapper.map(usuarioRequestDto, Usuario.class);
        user.setId(id);
        user.setFechaCreacion(LocalDate.now());
        return repo.save(user);
    }

    @Override
    public Usuario insertar(UsuarioRequestDto usuario) {
        Usuario user = modelMapper.map(usuario, Usuario.class);
        user.setFechaCreacion(LocalDate.now());
        return repo.save(user);
    }

    @Override
    public UsuarioResponseDto buscarPorId(Integer id) {
        Optional<Usuario> user = repo.findById(id);
        return user.map(usuario -> modelMapper.map(usuario, UsuarioResponseDto.class)).orElse(null);
    }

    @Override
    public List<UsuarioResponseDto> buscarTodos() {
        List<Usuario> usuarios = repo.findAll();
        return usuarios.stream().map(usuario -> modelMapper.map(usuario, UsuarioResponseDto.class)).toList();
    }
}

