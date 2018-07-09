package com.example.leonardo.avanzado01.repositories;

import com.example.leonardo.avanzado01.classes.Note;
import com.orm.SugarRecord;

import java.util.List;

public class NoteRepository {
    public static List<Note> list(){
        List<Note> notes = SugarRecord.listAll(Note.class);
        return notes;
    }

    public static List<Note> listByUser(Long idUser){
        List<Note> notes = SugarRecord.find(Note.class, "iduser = ?", String.valueOf(idUser));
        return notes;
    }

    public static Note read(Long id){
        Note note = SugarRecord.findById(Note.class, id);
        return note;
    }

    public static void create(Long idUser, String fecha, String titulo, String contenido, String favorito){
        Note note = new Note(idUser, fecha, titulo, contenido, favorito);
        SugarRecord.save(note);
    }

    public static void update(String titulo, String contenido, Long id){
        Note note = SugarRecord.findById(Note.class, id);
        note.setTitulo(titulo);
        note.setContenido(contenido);
        SugarRecord.save(note);
    }

    public static void favorito(String favorito, Long id){
        Note note = SugarRecord.findById(Note.class, id);
        note.setFavorito(favorito);
        SugarRecord.save(note);
    }

    public static void archivado(String archivado, Long id){
        Note note = SugarRecord.findById(Note.class, id);
        note.setFavorito(archivado);
        SugarRecord.save(note);
    }

    public static void delete(Long id){
        Note note = SugarRecord.findById(Note.class, id);
        SugarRecord.delete(note);
    }
}
