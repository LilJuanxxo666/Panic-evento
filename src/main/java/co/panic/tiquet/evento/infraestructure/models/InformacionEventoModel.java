package co.panic.tiquet.evento.infraestructure.models;
import co.panic.tiquet.evento.crosscutting.utils.UtilText;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "InformacionEvento")
public class InformacionEventoModel {

    @Id
    private UUID id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "artista")
    private String artista;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private GeneroModel genero;

    @Column(name = "fecha")
    private LocalDate fecha;

    private InformacionEventoModel() {
        setId(UtilUUID.DEFAULT_UUID);
        setDescripcion(UtilText.getUtilText().getDefaultValue());
        setArtista(UtilText.getUtilText().getDefaultValue());
        setGenero(GeneroModel.create());
        setFecha(LocalDate.now());
    }

    public InformacionEventoModel(UUID id, String descripcion, String artista, GeneroModel genero, LocalDate fecha) {
        setId(id);
        setDescripcion(descripcion);
        setArtista(artista);
        setGenero(genero);
        setFecha(fecha);
    }

    public static InformacionEventoModel create() {
        return new InformacionEventoModel();
    }

    public UUID getId() {
        return id;
    }

    public InformacionEventoModel setId(UUID id) {
        this.id = UtilUUID.getDefault(id);
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public InformacionEventoModel setDescripcion(String descripcion) {
        this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
        return this;
    }

    public String getArtista() {
        return artista;
    }

    public InformacionEventoModel setArtista(String artista) {
        this.artista = UtilText.getUtilText().applyTrim(artista);
        return this;
    }

    public GeneroModel getGenero() {
        return genero;
    }

    public InformacionEventoModel setGenero(GeneroModel genero) {
        this.genero = genero;
        return this;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public InformacionEventoModel setFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }
}
