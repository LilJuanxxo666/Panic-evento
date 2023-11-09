package co.panic.tiquet.evento.applicationcore.assembler.concrete;

import co.panic.tiquet.evento.applicationcore.assembler.Assembler;
import co.panic.tiquet.evento.applicationcore.domain.EstadoEvento;
import co.panic.tiquet.evento.applicationcore.domain.Evento;
import co.panic.tiquet.evento.infraestructure.models.EventoModel;

import java.util.List;

public class EventoAssembler implements Assembler<Evento, EventoModel> {

    private static final Assembler<Evento, EventoModel> INSTANCE = new EventoAssembler();

    private EventoAssembler() {
        super();
    }

    public static Assembler<Evento, EventoModel> getInstance() {
        return INSTANCE;
    }

    @Override
    public EventoModel toModelFromDomain(Evento domain) {
        return EventoModel.create()
                .setId(domain.getId())
                .setNombre(domain.getNombre())
                .setUbicacion(domain.getUbicacion())
                .setOferta(OfertaAssembler.getInstance().toModelFromDomain(domain.getOferta()))
                .setInformacionEvento(InformacionEventoAssembler.getInstance().toModelFromDomain(domain.getInformacionEvento()))
                .setPromotor(domain.getPromotor())
                .setEstado(EstadoEventoAssembler.getInstance().toModelFromDomain(domain.getEstado()));
    }

    @Override
    public Evento toDomainFromModel(EventoModel model) {
        return Evento.create()
                .setId(model.getId())
                .setNombre(model.getNombre())
                .setUbicacion(model.getUbicacion())
                .setOferta(OfertaAssembler.getInstance().toDomainFromModel(model.getOferta()))
                .setInformacionEvento(InformacionEventoAssembler.getInstance().toDomainFromModel(model.getInformacionEvento()))
                .setPromotor(model.getPromotor())
                .setEstado(EstadoEventoAssembler.getInstance().toDomainFromModel(model.getEstado()));
    }

    @Override
    public List<Evento> toDomainListFromModel(List<EventoModel> modelList) {
        return modelList.stream().map(entity -> toDomainFromModel(entity)).toList();
    }
}