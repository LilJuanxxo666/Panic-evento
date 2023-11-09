package co.panic.tiquet.evento.applicationcore.usesCase.impl;

import co.panic.tiquet.evento.applicationcore.assembler.concrete.EstadoEventoAssembler;
import co.panic.tiquet.evento.applicationcore.domain.EstadoEvento;
import co.panic.tiquet.evento.applicationcore.usesCase.EstadoEventoUseCase;
import co.panic.tiquet.evento.infraestructure.service.EstadoEventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EstadoEventoUseCaseImpl implements EstadoEventoUseCase {

    @Autowired
    private EstadoEventoServicio estadoEventoServicio;

    @Override
    public EstadoEvento consultarPorID(UUID id) {
        return EstadoEventoAssembler.getInstance().toDomainFromModel(estadoEventoServicio.listarPorID(id));
    }

    @Override
    public List<EstadoEvento> listarTodo() {
        return EstadoEventoAssembler.getInstance().toDomainListFromModel(estadoEventoServicio.listarTodo());
    }
}
