package co.panic.tiquet.evento.infraestructure.models;
import co.panic.tiquet.evento.crosscutting.utils.UtilObject;
import co.panic.tiquet.evento.crosscutting.utils.UtilText;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Evento")
public class EventoModel {

    @Id
    private UUID id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ubicacion")
    private String ubicacion;

    @OneToOne
    @JoinColumn(name = "oferta_id")
    private OfertaModel oferta;

    @OneToOne
    @JoinColumn(name = "informacion_evento_id")
    private InformacionEventoModel informacionEvento;

    @Column(name = "promotor")
    private String promotor;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoEventoModel estado;

    private EventoModel() {
        setId(UtilUUID.DEFAULT_UUID);
        setNombre(UtilText.getUtilText().getDefaultValue());
        setUbicacion(UtilText.getUtilText().getDefaultValue());
        setOferta(OfertaModel.create());
        setInformacionEvento(InformacionEventoModel.create());
        setPromotor(UtilText.getUtilText().getDefaultValue());
        setEstado(EstadoEventoModel.create());
    }

    public EventoModel(UUID id, String nombre, String ubicacion, OfertaModel oferta,
                       InformacionEventoModel informacionEvento, String promotor, EstadoEventoModel estado) {
        setId(id);
        setNombre(nombre);
        setUbicacion(ubicacion);
        setOferta(oferta);
        setInformacionEvento(informacionEvento);
        setPromotor(promotor);
        setEstado(estado);
    }

    public static EventoModel create() {
        return new EventoModel();
    }

    public UUID getId() {
        return id;
    }

    public EventoModel setId(UUID id) {
        this.id = UtilUUID.getDefault(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public EventoModel setNombre(String nombre) {
        this.nombre = UtilText.getUtilText().applyTrim(nombre);
        return this;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public EventoModel setUbicacion(String ubicacion) {
        this.ubicacion = UtilText.getUtilText().applyTrim(ubicacion);
        return this;
    }

    public OfertaModel getOferta() {
        return oferta;
    }

    public EventoModel setOferta(OfertaModel oferta) {
        this.oferta = UtilObject.getDefault(oferta, OfertaModel.create());
        return this;
    }

    public InformacionEventoModel getInformacionEvento() {
        return informacionEvento;
    }

    public EventoModel setInformacionEvento(InformacionEventoModel informacionEvento) {
        this.informacionEvento = UtilObject.getDefault(informacionEvento, InformacionEventoModel.create());
        return this;
    }

    public String getPromotor() {
        return promotor;
    }

    public EventoModel setPromotor(String promotor) {
        this.promotor = UtilText.getUtilText().applyTrim(promotor);
        return this;
    }

    public EstadoEventoModel getEstado() {
        return estado;
    }

    public EventoModel setEstado(EstadoEventoModel estado) {
        this.estado = UtilObject.getDefault(estado, EstadoEventoModel.create());
        return this;
    }
}

