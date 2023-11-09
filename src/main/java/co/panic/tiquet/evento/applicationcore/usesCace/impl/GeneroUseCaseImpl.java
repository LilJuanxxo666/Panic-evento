package co.panic.tiquet.evento.applicationcore.usesCace.impl;

import co.panic.tiquet.evento.applicationcore.assembler.concrete.GeneroAssembler;
import co.panic.tiquet.evento.applicationcore.domain.Genero;
import co.panic.tiquet.evento.applicationcore.usesCace.GeneroUseCase;
import co.panic.tiquet.evento.infraestructure.service.GeneroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GeneroUseCaseImpl implements GeneroUseCase {

    @Autowired
    private GeneroServicio generoServicio;

    @Override
    public Genero consultarPorID(UUID id) {
        return GeneroAssembler.getInstance().toDomainFromModel(generoServicio.consultarPorID(id));
    }

    @Override
    public List<Genero> listarTodo() {
        return GeneroAssembler.getInstance().toDomainListFromModel(generoServicio.listarTodo());
    }
}
