package co.panic.tiquet.evento.applicationcore.domain;

import co.panic.tiquet.evento.crosscutting.utils.UtilNumber;
import co.panic.tiquet.evento.crosscutting.utils.UtilText;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;

import java.util.UUID;

public class Area {
    private UUID id;
    private String nombre;
    private String descripcion;
    private int cantAforo;
    private String rangEdad;

    private Area() {
        setId(UtilUUID.DEFAULT_UUID);
        setNombre(UtilText.getUtilText().getDefaultValue());
        setDescripcion(UtilText.getUtilText().getDefaultValue());
        setCantAforo(UtilNumber.ZERO.intValue());
        setRangEdad(UtilText.getUtilText().getDefaultValue());
    }

    public Area(UUID id, String nombre, String descripcion, int cantAforo, String rangEdad) {
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
        setCantAforo(cantAforo);
        setRangEdad(rangEdad);
    }

    public static Area create() {
        return new Area();
    }

    public UUID getId() {
        return id;
    }

    public Area setId(UUID identificador) {
        this.id = UtilUUID.getDefault(identificador);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Area setNombre(String nombre) {
        this.nombre = UtilText.getUtilText().applyTrim(nombre);
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Area setDescripcion(String descripcion) {
        this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
        return this;
    }

    public int getCantAforo() {
        return cantAforo;
    }

    public Area setCantAforo(int cantAforo) {
        this.cantAforo = UtilNumber.getUtilNumber().getDefault(cantAforo).intValue();
        return this;
    }

    public String getRangEdad() {
        return rangEdad;
    }

    public Area setRangEdad(String rangEdad) {
        this.rangEdad = UtilText.getUtilText().applyTrim(rangEdad);
        return this;
    }
}
