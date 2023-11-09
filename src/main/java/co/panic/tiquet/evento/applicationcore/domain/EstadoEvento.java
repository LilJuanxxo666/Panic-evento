package co.panic.tiquet.evento.applicationcore.domain;

import co.panic.tiquet.evento.crosscutting.utils.UtilText;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;

import java.util.UUID;

public class EstadoEvento {
    private UUID id;
    private String nombre;
    private String descripcion;

    private EstadoEvento() {
        setId(UtilUUID.DEFAULT_UUID);
        setNombre(UtilText.getUtilText().getDefaultValue());
        setDescripcion(UtilText.getUtilText().getDefaultValue());
    }

    public EstadoEvento(UUID id, String nombre, String descripcion) {
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public static EstadoEvento create() {
        return new EstadoEvento();
    }

    public UUID getId() {
        return id;
    }

    public EstadoEvento setId(UUID identificador) {
        this.id = UtilUUID.getDefault(identificador);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoEvento setNombre(String nombre) {
        this.nombre = UtilText.getUtilText().applyTrim(nombre);
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoEvento setDescripcion(String descripcion) {
        this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
        return this;
    }
}