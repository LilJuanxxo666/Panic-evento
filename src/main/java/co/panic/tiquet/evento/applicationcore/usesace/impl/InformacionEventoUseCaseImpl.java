package co.panic.tiquet.evento.applicationcore.usesace.impl;

import co.panic.tiquet.evento.applicationcore.assembler.concrete.GeneroAssembler;
import co.panic.tiquet.evento.applicationcore.assembler.concrete.InformacionEventoAssembler;
import co.panic.tiquet.evento.applicationcore.domain.InformacionEvento;
import co.panic.tiquet.evento.applicationcore.usesace.InformacionEventoUseCase;
import co.panic.tiquet.evento.infraestructure.models.InformacionEventoModel;
import co.panic.tiquet.evento.infraestructure.service.InformacionEventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class InformacionEventoUseCaseImpl implements InformacionEventoUseCase {

    @Autowired
    private InformacionEventoServicio informacionEventoServicio;

    @Override
    public InformacionEvento guardar(InformacionEvento informacionEvento) {
        InformacionEventoModel informacionEventoCreado = InformacionEventoModel.create()
                .setId(UUID.randomUUID())
                .setDescripcion(informacionEvento.getDescripcion())
                .setArtista(informacionEvento.getArtista())
                .setGenero(GeneroAssembler.getInstance().toModelFromDomain(informacionEvento.getGenero()))
                .setFecha(informacionEvento.getFecha());

        InformacionEventoModel informacionEventoGuardado = informacionEventoServicio.guardar(informacionEventoCreado);

        return InformacionEventoAssembler.getInstance().toDomainFromModel(informacionEventoGuardado);
    }

    @Override
    public InformacionEvento listarPorID(UUID id) {
        return InformacionEventoAssembler.getInstance().toDomainFromModel(informacionEventoServicio.listarPorID(id));
    }

    @Override
    public List<InformacionEvento> listarTodo() {
        return InformacionEventoAssembler.getInstance().toDomainListFromModel(informacionEventoServicio.listarTodo());
    }

    @Override
    public Boolean borrar(UUID id) {
        return informacionEventoServicio.borrar(id);
    }

    @Override
    public Boolean modificar(InformacionEvento informacionEvento) {
        InformacionEventoModel informacionEventoModificado = InformacionEventoModel.create()
                .setId(informacionEvento.getId())
                .setDescripcion(informacionEvento.getDescripcion())
                .setArtista(informacionEvento.getArtista())
                .setGenero(GeneroAssembler.getInstance().toModelFromDomain(informacionEvento.getGenero()))
                .setFecha(informacionEvento.getFecha());
        return informacionEventoServicio.modificar(informacionEventoModificado);
    }
}