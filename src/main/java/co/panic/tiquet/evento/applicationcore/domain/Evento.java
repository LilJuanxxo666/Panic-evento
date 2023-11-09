package co.panic.tiquet.evento.applicationcore.domain;

import co.panic.tiquet.evento.crosscutting.utils.UtilObject;
import co.panic.tiquet.evento.crosscutting.utils.UtilText;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;

import java.util.UUID;

public class Evento {
    private UUID id;
    private String nombre;
    private String ubicacion;
    private Oferta oferta;
    private InformacionEvento informacionEvento;
    private String promotor;
    private EstadoEvento estado;

    private Evento() {
        setId(UtilUUID.DEFAULT_UUID);
        setNombre(UtilText.getUtilText().getDefaultValue());
        setUbicacion(UtilText.getUtilText().getDefaultValue());
        setOferta(Oferta.create());
        setInformacionEvento(InformacionEvento.create());
        setPromotor(UtilText.getUtilText().getDefaultValue());
        setEstado(EstadoEvento.create());
    }

    public Evento(UUID id, String nombre, String ubicacion, Oferta oferta, InformacionEvento informacionEvento, String promotor, EstadoEvento estado) {
        setId(id);
        setNombre(nombre);
        setUbicacion(ubicacion);
        setOferta(oferta);
        setInformacionEvento(informacionEvento);
        setPromotor(promotor);
        setEstado(estado);
    }

    public static Evento create() {
        return new Evento();
    }

    public UUID getId() {
        return id;
    }

    public Evento setId(UUID id) {
        this.id = UtilUUID.getDefault(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Evento setNombre(String nombre) {
        this.nombre = UtilText.getUtilText().applyTrim(nombre);
        return this;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Evento setUbicacion(String ubicacion) {
        this.ubicacion = UtilText.getUtilText().applyTrim(ubicacion);
        return this;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public Evento setOferta(Oferta oferta) {
        this.oferta = UtilObject.getDefault(oferta, Oferta.create());
        return this;
    }

    public InformacionEvento getInformacionEvento() {
        return informacionEvento;
    }

    public Evento setInformacionEvento(InformacionEvento informacionEvento) {
        this.informacionEvento = UtilObject.getDefault(informacionEvento, InformacionEvento.create());
        return this;
    }

    public String getPromotor() {
        return promotor;
    }

    public Evento setPromotor(String promotor) {
        this.promotor = UtilText.getUtilText().applyTrim(promotor);
        return this;
    }

    public EstadoEvento getEstado() {
        return estado;
    }

    public Evento setEstado(EstadoEvento estado) {
        this.estado = UtilObject.getDefault(estado, EstadoEvento.create());
        return this;
    }
}