package com.ecommerce.natureba.controller;

import com.ecommerce.natureba.model.Produto;
import com.ecommerce.natureba.repository.CategoriaRepository;
import com.ecommerce.natureba.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getByName(@PathVariable String nome){
        return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @GetMapping("/preco_menor")
    public ResponseEntity<List<Produto>> getPrecoMaior(){
        return ResponseEntity.ok(produtoRepository.findAllByPrecoOrderByPreco());
    }
}
