package co.panic.tiquet.evento.applicationcore.domain;

import co.panic.tiquet.evento.crosscutting.utils.UtilText;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;

import java.time.LocalDate;
import java.util.UUID;

public class InformacionEvento {
    private UUID id;
    private String descripcion;
    private String artista;
    private Genero genero;
    private LocalDate fecha;

    private InformacionEvento() {
        setId(UtilUUID.DEFAULT_UUID);
        setDescripcion(UtilText.getUtilText().getDefaultValue());
        setArtista(UtilText.getUtilText().getDefaultValue());
        setGenero(Genero.create());
        setFecha(LocalDate.now());
    }

    public InformacionEvento(UUID id, String descripcion, String artista, Genero genero, LocalDate fecha) {
        setId(id);
        setDescripcion(descripcion);
        setArtista(artista);
        setGenero(genero);
        setFecha(fecha);
    }

    public static InformacionEvento create() {
        return new InformacionEvento();
    }

    public UUID getId() {
        return id;
    }

    public InformacionEvento setId(UUID id) {
        this.id = UtilUUID.getDefault(id);
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public InformacionEvento setDescripcion(String descripcion) {
        this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
        return this;
    }

    public String getArtista() {
        return artista;
    }

    public InformacionEvento setArtista(String artista) {
        this.artista = UtilText.getUtilText().applyTrim(artista);
        return this;
    }

    public Genero getGenero() {
        return genero;
    }

    public InformacionEvento setGenero(Genero genero) {
        this.genero = genero;
        return this;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public InformacionEvento setFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }
}