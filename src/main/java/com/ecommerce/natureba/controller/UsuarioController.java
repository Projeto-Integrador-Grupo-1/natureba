package com.ecommerce.natureba.controller;


import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import com.ecommerce.natureba.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.ecommerce.natureba.model.Usuario;
import com.ecommerce.natureba.model.UsuarioLogin;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {


	 	@PostMapping("/logar")
	    public ResponseEntity<UsuarioLogin> login(@RequestBody Optional<UsuarioLogin> usuarioLogin){
	        return usuarioService.autenticarUsuario(usuarioLogin)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	    }

	    @PostMapping("/cadastrar")
	    public ResponseEntity<Usuario> postUsuario(@Valid @RequestBody Usuario usuario){
	        return usuarioService.cadastrarUsuario(usuario)
	                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
	                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

	    }

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        return usuarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
