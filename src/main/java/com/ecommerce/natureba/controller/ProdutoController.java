package com.ecommerce.natureba.controller;

import com.ecommerce.natureba.model.Produto;
import com.ecommerce.natureba.repository.CategoriaRepository;
import com.ecommerce.natureba.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;
    @PostMapping
    public ResponseEntity<Produto> postProduto(@Valid @RequestBody Produto produto){
        return categoriaRepository.findById(produto.getCategoria().getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto)))
                .orElse(ResponseEntity.badRequest().build());
    }
}
