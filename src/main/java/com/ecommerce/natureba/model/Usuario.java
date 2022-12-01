package com.ecommerce.natureba.model;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(mame = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo é obrigatório e não pode ser vazio!")
    @Size(min = 5, max = 100, message = "O tamanho minimo de 5 e maximo 100 caracteres!" )
    private String nome;

    @NotBlank(message = "O atributo é obrigatório e não pode ser vazio!")
    @Size(min = 10, message = "O tamanho minimo de 10" )
    private String usuario;

    @NotBlank(message = "O atributo é obrigatório e não pode ser vazio!")
    @Size(min = 20, message = "O tamanho minimo de 20!" )
    private String senha;

    @NotBlank(message = "O atributo é obrigatório e não pode ser vazio!")
    @Size(min = 5, message = "O tamanho minimo de 1 e maximo 20 caracteres!" )
    private String foto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}