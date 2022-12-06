package com.ecommerce.natureba.controller;

import com.ecommerce.natureba.model.Usuario;
import com.ecommerce.natureba.repository.UsuarioRepository;
import com.ecommerce.natureba.service.UsuarioService;
import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
   @Autowired
    UsuarioRepository usuarioRepository;

   @Autowired
    UsuarioService usuarioService;
    @PutMapping("/atualizar")
    public ResponseEntity<Usuario> putUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(usuario)
                .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePostagem(@PathVariable Long id) {

        return usuarioRepository.findById(id)
                .map(resposta -> {
                    usuarioRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

 }


