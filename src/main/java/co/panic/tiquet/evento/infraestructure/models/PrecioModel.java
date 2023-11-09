package co.panic.tiquet.evento.infraestructure.models;

import co.panic.tiquet.evento.crosscutting.utils.UtilNumber;
import co.panic.tiquet.evento.crosscutting.utils.UtilObject;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Precio")
public class PrecioModel {

    @Id
    private UUID id;

    @Column(name = "precio")
    private double precio;

    @ManyToOne
    @JoinColumn(name = "divisa_id")
    private DivisaModel divisa;

    private PrecioModel() {
        setId(UtilUUID.DEFAULT_UUID);
        setPrecio(UtilNumber.ZERO.intValue());
        setDivisa(DivisaModel.create());
    }

    public PrecioModel(UUID id, double precio, DivisaModel divisa) {
        setId(id);
        setPrecio(precio);
        setDivisa(divisa);
    }

    public static PrecioModel create() {
        return new PrecioModel();
    }

    public UUID getId() {
        return id;
    }

    public PrecioModel setId(UUID id) {
        this.id = UtilUUID.getDefault(id);
        return this;
    }

    public double getPrecio() {
        return precio;
    }

    public PrecioModel setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public DivisaModel getDivisa() {
        return divisa;
    }

    public PrecioModel setDivisa(DivisaModel divisa) {
        this.divisa = UtilObject.getDefault(divisa, DivisaModel.create());
        return this;
    }
}
