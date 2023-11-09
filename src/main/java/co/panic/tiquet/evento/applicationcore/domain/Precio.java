package co.panic.tiquet.evento.applicationcore.domain;

import co.panic.tiquet.evento.crosscutting.utils.UtilNumber;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;

import java.util.UUID;

public class Precio {
    private UUID id;
    private double precio;
    private Divisa divisa;

    private Precio() {
        setId(UtilUUID.DEFAULT_UUID);
        setPrecio(UtilNumber.ZERO.intValue());
        setDivisa(Divisa.create());
    }

    public Precio(UUID id, double precio, Divisa divisa) {
        setId(id);
        setPrecio(precio);
        setDivisa(divisa);
    }

    public static Precio create() {
        return new Precio();
    }

    public UUID getId() {
        return id;
    }

    public Precio setId(UUID identificador) {
        this.id = UtilUUID.getDefault(identificador);
        return this;
    }

    public double getPrecio() {
        return precio;
    }

    public Precio setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public Divisa getDivisa() {
        return divisa;
    }

    public Precio setDivisa(Divisa divisa) {
        this.divisa = divisa;
        return this;
    }
}
