package com.ecommerce.natureba.controller;

import com.ecommerce.natureba.model.Categoria;
import com.ecommerce.natureba.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins =  "*", allowedHeaders = "*")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Categoria>> getByCategoria(@PathVariable String categoria){
        return ResponseEntity.ok(categoriaRepository.findAllByCategoriaContainingIgnoreCase(categoria));
    }

}