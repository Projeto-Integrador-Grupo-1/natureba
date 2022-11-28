package com.ecommerce.natureba.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo é obrigatório e não pode ser vazio!")
    @Size(min = 1, max = 20, message = "O tamanho minimo de 1 e maximo 20 caracteres!" )
    private String categoria;

    @NotNull(message = "O atributo da descrição e obrigatório!")
    @Size(min = 1, max = 1000, message = "O tamanho minimo de 1 e maximo 1000 caracteres!" )
    private String descricao;

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String categoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String descricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
