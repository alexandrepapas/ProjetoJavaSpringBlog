package com.alexandrepapas.desafioBlog.dtos;

public class PostsDTO {
    private Long id;
    private String titulo;
    private String conteudo;
    private Long autorId;


    public PostsDTO(Long id, String titulo, String conteudo, Long autorId) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autorId = autorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }
}
