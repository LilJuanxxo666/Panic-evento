package co.panic.tiquet.evento.infraestructure.models;

import co.panic.tiquet.evento.crosscutting.utils.UtilText;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "EstadoEvento")
public class EstadoEventoModel {

    @Id
    private UUID id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    private EstadoEventoModel() {
        setId(UtilUUID.DEFAULT_UUID);
        setNombre(UtilText.getUtilText().getDefaultValue());
        setDescripcion(UtilText.getUtilText().getDefaultValue());
    }

    public EstadoEventoModel(UUID id, String nombre, String descripcion) {
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public static EstadoEventoModel create() {
        return new EstadoEventoModel();
    }

    public UUID getId() {
        return id;
    }

    public EstadoEventoModel setId(UUID id) {
        this.id = UtilUUID.getDefault(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoEventoModel setNombre(String nombre) {
        this.nombre = UtilText.getUtilText().applyTrim(nombre);
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoEventoModel setDescripcion(String descripcion) {
        this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
        return this;
    }
}
