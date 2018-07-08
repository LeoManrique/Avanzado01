package com.example.leonardo.avanzado01.classes;

import com.orm.dsl.Table;

@Table
public class Note {

    private Long id;
    private Long idUser;
    private String titulo;
    private String fecha;
    private String contenido;
    private String favorito;
    private String archivado;

    public Note() {
    }

    public Note(Long idUser, String titulo, String fecha, String contenido, String favorito) {
        this.idUser = idUser;
        this.titulo = titulo;
        this.fecha = fecha;
        this.contenido = contenido;
        this.favorito = favorito;
        this.archivado = "N";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFavorito() {
        return favorito;
    }

    public void setFavorito(String favorito) {
        this.favorito = favorito;
    }

    public String getArchivado() {
        return archivado;
    }

    public void setArchivado(String archivado) {
        this.archivado = archivado;
    }

    public String toString(){
        return "Note{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", contenido='" + contenido + '\'' +
                ", favorito='" + favorito + '\'' +
                ", archivado='" + archivado + '\'' +
                '}';
    }
}