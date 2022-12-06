package com.ecommerce.natureba.service;

import com.ecommerce.natureba.model.Usuario;
<<<<<<< HEAD
import com.ecommerce.natureba.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

=======
import com.ecommerce.natureba.model.UsuarioLogin;
import com.ecommerce.natureba.repository.UsuarioRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.Charset;
>>>>>>> task05
import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
<<<<<<< HEAD
    UsuarioRepository usuarioRepository;
=======
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> cadastrarUsuario(Usuario usuario) {

        if (usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
            return Optional.empty();

        if (usuario.getFoto().isBlank())
            usuario.setFoto("https://i.imgur.com/Zz4rzVR.png");

        usuario.setSenha(criptografarSenha(usuario.getSenha()));

        return Optional.of(usuarioRepository.save(usuario));

    }
    private String criptografarSenha(String senha) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode(senha);
    }

>>>>>>> task05
    public Optional<Usuario> atualizarUsuario(Usuario usuario) {

        if(usuarioRepository.findById(usuario.getId()).isPresent()) {

            Optional<Usuario> buscaUsuario = usuarioRepository.findByUsuario(usuario.getUsuario());

            if ( (buscaUsuario.isPresent()) && ( buscaUsuario.get().getId() != usuario.getId()))
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Usuário já existe!", null);

<<<<<<< HEAD
           /** if (calcularIdade(usuario.getDataNascimento()) < 18)
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Usuário é menor de 18 anos", null);

            if (usuario.getFoto().isBlank())
                usuario.setFoto("https://i.imgur.com/Zz4rzVR.png");

            usuario.setSenha(criptografarSenha(usuario.getSenha())); **/
=======
            if (usuario.getFoto().isBlank())
                usuario.setFoto("https://i.imgur.com/Zz4rzVR.png");

            usuario.setSenha(criptografarSenha(usuario.getSenha()));
>>>>>>> task05

            return Optional.ofNullable(usuarioRepository.save(usuario));

        }

        return Optional.empty();

    }
<<<<<<< HEAD
=======



    public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin){

        Optional<Usuario> buscaUsuario = usuarioRepository.findByUsuario(usuarioLogin.get().getUsuario());

        if(buscaUsuario.isPresent()) {

            if(compararSenhas(usuarioLogin.get().getSenha(), buscaUsuario.get().getSenha())){

                usuarioLogin.get().setId(buscaUsuario.get().getId());
                usuarioLogin.get().setNome(buscaUsuario.get().getNome());
                usuarioLogin.get().setFoto(buscaUsuario.get().getFoto());
                usuarioLogin.get().setToken(gerarBasicToken(usuarioLogin.get().getUsuario(), usuarioLogin.get().getSenha()));
                usuarioLogin.get().setSenha(buscaUsuario.get().getSenha());

                return usuarioLogin;
            }
        }

        return Optional.empty();
    }

    private boolean compararSenhas(String senhaDigitada, String senhaBanco) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.matches(senhaDigitada, senhaBanco);
    }

    private String gerarBasicToken(String usuario, String senha) {

        String token = usuario + ":" + senha;
        byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));

        return "Basic " + new String(tokenBase64);

    }

>>>>>>> task05
}
