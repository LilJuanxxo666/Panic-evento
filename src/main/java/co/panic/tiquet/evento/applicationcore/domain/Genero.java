package co.panic.tiquet.evento.applicationcore.domain;

import co.panic.tiquet.evento.crosscutting.utils.UtilText;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;

import java.util.UUID;

public class Genero {
    private UUID id;
    private String nombre;
    private String descripcion;

    private Genero() {
        setId(UtilUUID.DEFAULT_UUID);
        setNombre(UtilText.getUtilText().getDefaultValue());
        setDescripcion(UtilText.getUtilText().getDefaultValue());
    }

    public Genero(UUID id, String nombre, String descripcion) {
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public static Genero create() {
        return new Genero();
    }

    public UUID getId() {
        return id;
    }

    public Genero setId(final UUID identificador) {
        this.id = UtilUUID.getDefault(identificador);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Genero setNombre(String nombre) {
        this.nombre = UtilText.getUtilText().applyTrim(nombre);
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Genero setDescripcion(String descripcion) {
        this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
        return this;
    }
}
