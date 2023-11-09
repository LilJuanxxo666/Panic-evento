package co.panic.tiquet.evento.applicationcore.usesace.impl;

import co.panic.tiquet.evento.applicationcore.assembler.concrete.AreaAssembler;
import co.panic.tiquet.evento.applicationcore.assembler.concrete.OfertaAssembler;
import co.panic.tiquet.evento.applicationcore.assembler.concrete.PrecioAssembler;
import co.panic.tiquet.evento.applicationcore.domain.Oferta;
import co.panic.tiquet.evento.applicationcore.usesace.OfertaUseCase;
import co.panic.tiquet.evento.infraestructure.models.OfertaModel;
import co.panic.tiquet.evento.infraestructure.service.OfertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class OfertaUseCaseImpl implements OfertaUseCase {

    @Autowired
    private OfertaServicio ofertaServicio;

    @Override
    public Oferta guardar(Oferta oferta) {
        OfertaModel ofertaCreada = OfertaModel.create()
                .setId(UUID.randomUUID())
                .setNombre(oferta.getNombre())
                .setDescripcion(oferta.getDescripcion())
                .setPrecio(PrecioAssembler.getInstance().toModelFromDomain(oferta.getPrecio()))
                .setArea(AreaAssembler.getInstance().toModelFromDomain(oferta.getArea()));

        OfertaModel ofertaGuardada = ofertaServicio.guardar(ofertaCreada);

        return OfertaAssembler.getInstance().toDomainFromModel(ofertaGuardada);
    }

    @Override
    public Oferta listarPorID(UUID id) {
        return OfertaAssembler.getInstance().toDomainFromModel(ofertaServicio.listarPorID(id));
    }

    @Override
    public List<Oferta> listarTodo() {
        return OfertaAssembler.getInstance().toDomainListFromModel(ofertaServicio.listarTodo());
    }

    @Override
    public Boolean borrar(UUID id) {
        return ofertaServicio.borrar(id);
    }

    @Override
    public Boolean modificar(Oferta oferta) {
        OfertaModel ofertaModificada = OfertaModel.create()
                .setId(oferta.getId())
                .setNombre(oferta.getNombre())
                .setDescripcion(oferta.getDescripcion())
                .setPrecio(PrecioAssembler.getInstance().toModelFromDomain(oferta.getPrecio()))
                .setArea(AreaAssembler.getInstance().toModelFromDomain(oferta.getArea()));
        return ofertaServicio.modificar(ofertaModificada);
    }
}
