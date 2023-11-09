package co.panic.tiquet.evento.infraestructure.models;

import co.panic.tiquet.evento.crosscutting.utils.UtilText;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Oferta")
public class OfertaModel {

    @Id
    private UUID id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "precio_id")
    private PrecioModel precio;

    @OneToOne
    @JoinColumn(name = "area_id")
    private AreaModel area;

    private OfertaModel() {
        setId(UtilUUID.DEFAULT_UUID);
        setNombre(UtilText.getUtilText().getDefaultValue());
        setDescripcion(UtilText.getUtilText().getDefaultValue());
        setPrecio(PrecioModel.create());
        setArea(AreaModel.create());
    }

    public OfertaModel(UUID id, String nombre, String descripcion, PrecioModel precio, AreaModel area) {
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
        setArea(area);
    }

    public static OfertaModel create() {
        return new OfertaModel();
    }

    public UUID getId() {
        return id;
    }

    public OfertaModel setId(UUID id) {
        this.id = UtilUUID.getDefault(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public OfertaModel setNombre(String nombre) {
        this.nombre = UtilText.getUtilText().applyTrim(nombre);
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public OfertaModel setDescripcion(String descripcion) {
        this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
        return this;
    }

    public PrecioModel getPrecio() {
        return precio;
    }

    public OfertaModel setPrecio(PrecioModel precio) {
        this.precio = precio;
        return this;
    }

    public AreaModel getArea() {
        return area;
    }

    public OfertaModel setArea(AreaModel area) {
        this.area = area;
        return this;
    }
}
