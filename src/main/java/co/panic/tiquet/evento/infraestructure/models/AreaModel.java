package co.panic.tiquet.evento.infraestructure.models;

import co.panic.tiquet.evento.crosscutting.utils.UtilNumber;
import co.panic.tiquet.evento.crosscutting.utils.UtilText;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "Area")
public class AreaModel {

    @Id
    private UUID id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantAforo")
    private int cantAforo;

    @Column(name = "rangEdad")
    private String rangEdad;

    private AreaModel() {
        setId(UtilUUID.DEFAULT_UUID);
        setNombre(UtilText.getUtilText().getDefaultValue());
        setDescripcion(UtilText.getUtilText().getDefaultValue());
        setCantAforo(UtilNumber.ZERO.intValue());
        setRangEdad(UtilText.getUtilText().getDefaultValue());
    }

    public AreaModel(UUID id, String nombre, String descripcion, int cantAforo, String rangEdad) {
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
        setCantAforo(cantAforo);
        setRangEdad(rangEdad);
    }

    public static AreaModel create() {
        return new AreaModel();
    }

    public UUID getId() {
        return id;
    }

    public AreaModel setId(UUID id) {
        this.id = UtilUUID.getDefault(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public AreaModel setNombre(String nombre) {
        this.nombre = UtilText.getUtilText().applyTrim(nombre);
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public AreaModel setDescripcion(String descripcion) {
        this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
        return this;
    }

    public int getCantAforo() {
        return cantAforo;
    }

    public AreaModel setCantAforo(int cantAforo) {
        this.cantAforo = UtilNumber.getUtilNumber().getDefault(cantAforo).intValue();
        return this;
    }

    public String getRangEdad() {
        return rangEdad;
    }

    public AreaModel setRangEdad(String rangEdad) {
        this.rangEdad = UtilText.getUtilText().applyTrim(rangEdad);
        return this;
    }
}
