package com.ecommerce.natureba.repository;

import com.ecommerce.natureba.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    List<Categoria> findAllByCategoriaContainingIgnoreCase(@Param("categoria")String Categoria);
}
