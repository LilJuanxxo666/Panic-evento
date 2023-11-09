package co.panic.tiquet.evento.applicationcore.usesace.impl;

import co.panic.tiquet.evento.applicationcore.assembler.concrete.EstadoEventoAssembler;
import co.panic.tiquet.evento.applicationcore.assembler.concrete.EventoAssembler;
import co.panic.tiquet.evento.applicationcore.assembler.concrete.InformacionEventoAssembler;
import co.panic.tiquet.evento.applicationcore.assembler.concrete.OfertaAssembler;
import co.panic.tiquet.evento.applicationcore.domain.Evento;
import co.panic.tiquet.evento.applicationcore.usesace.EventoUseCase;
import co.panic.tiquet.evento.infraestructure.models.EventoModel;
import co.panic.tiquet.evento.infraestructure.service.EventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EventoUseCaseImpl implements EventoUseCase {

    @Autowired
    private EventoServicio eventoServicio;

    @Override
    public Evento guardar(Evento evento) {
        EventoModel eventoCreado = EventoModel.create()
                .setId(UUID.randomUUID())
                .setNombre(evento.getNombre())
                .setUbicacion(evento.getUbicacion())
                .setOferta(OfertaAssembler.getInstance().toModelFromDomain(evento.getOferta()))
                .setInformacionEvento(InformacionEventoAssembler.getInstance().toModelFromDomain(evento.getInformacionEvento()))
                .setPromotor(evento.getPromotor())
                .setEstado(EstadoEventoAssembler.getInstance().toModelFromDomain(evento.getEstado()));

        EventoModel eventoGuardado = eventoServicio.guardar(eventoCreado);

        return EventoAssembler.getInstance().toDomainFromModel(eventoGuardado);
    }

    @Override
    public Evento listarPorID(UUID id) {
        return EventoAssembler.getInstance().toDomainFromModel(eventoServicio.listarPorID(id));
    }

    @Override
    public List<Evento> listarTodo() {
        return EventoAssembler.getInstance().toDomainListFromModel(eventoServicio.listarTodo());
    }

    @Override
    public Boolean borrar(UUID id) {
        return eventoServicio.borrar(id);
    }

    @Override
    public Boolean modificar(Evento evento) {
        EventoModel eventoCreado = EventoModel.create()
                .setId(evento.getId())
                .setNombre(evento.getNombre())
                .setUbicacion(evento.getUbicacion())
                .setOferta(OfertaAssembler.getInstance().toModelFromDomain(evento.getOferta()))
                .setInformacionEvento(InformacionEventoAssembler.getInstance().toModelFromDomain(evento.getInformacionEvento()))
                .setPromotor(evento.getPromotor())
                .setEstado(EstadoEventoAssembler.getInstance().toModelFromDomain(evento.getEstado()));
        return eventoServicio.modificar(eventoCreado);
    }
}
