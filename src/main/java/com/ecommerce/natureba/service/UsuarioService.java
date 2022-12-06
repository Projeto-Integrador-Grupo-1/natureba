package com.ecommerce.natureba.service;

import com.ecommerce.natureba.model.Usuario;
import com.ecommerce.natureba.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    public Optional<Usuario> atualizarUsuario(Usuario usuario) {

        if(usuarioRepository.findById(usuario.getId()).isPresent()) {

            Optional<Usuario> buscaUsuario = usuarioRepository.findByUsuario(usuario.getUsuario());

            if ( (buscaUsuario.isPresent()) && ( buscaUsuario.get().getId() != usuario.getId()))
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Usuário já existe!", null);

           /** if (calcularIdade(usuario.getDataNascimento()) < 18)
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Usuário é menor de 18 anos", null);

            if (usuario.getFoto().isBlank())
                usuario.setFoto("https://i.imgur.com/Zz4rzVR.png");

            usuario.setSenha(criptografarSenha(usuario.getSenha())); **/

            return Optional.ofNullable(usuarioRepository.save(usuario));

        }

        return Optional.empty();

    }
}
