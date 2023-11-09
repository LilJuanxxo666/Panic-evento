package co.panic.tiquet.evento.applicationcore.domain;

import co.panic.tiquet.evento.crosscutting.utils.UtilText;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;

import java.util.UUID;

public class Oferta {
    private UUID id;
    private String nombre;
    private String descripcion;
    private Precio precio;
    private Area area;

    private Oferta() {
        setId(UtilUUID.DEFAULT_UUID);
        setNombre(UtilText.getUtilText().getDefaultValue());
        setDescripcion(UtilText.getUtilText().getDefaultValue());
        setPrecio(Precio.create());
        setArea(Area.create());
    }

    public Oferta(UUID id, String nombre, String descripcion, Precio precio, Area area) {
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
        setArea(area);
    }

    public static Oferta create() {
        return new Oferta();
    }

    public UUID getId() {
        return id;
    }

    public Oferta setId(UUID identificador) {
        this.id = UtilUUID.getDefault(identificador);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Oferta setNombre(String nombre) {
        this.nombre = UtilText.getUtilText().applyTrim(nombre);
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Oferta setDescripcion(String descripcion) {
        this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
        return this;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Oferta setPrecio(Precio precio) {
        this.precio = precio;
        return this;
    }

    public Area getArea() {
        return area;
    }

    public Oferta setArea(Area area) {
        this.area = area;
        return this;
    }
}
