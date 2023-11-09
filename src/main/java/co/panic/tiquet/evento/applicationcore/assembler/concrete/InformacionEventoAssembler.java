package co.panic.tiquet.evento.applicationcore.assembler.concrete;

import co.panic.tiquet.evento.applicationcore.assembler.Assembler;
import co.panic.tiquet.evento.applicationcore.domain.InformacionEvento;
import co.panic.tiquet.evento.infraestructure.models.InformacionEventoModel;

import java.util.List;

public class InformacionEventoAssembler implements Assembler<InformacionEvento, InformacionEventoModel> {

    private static final Assembler<InformacionEvento, InformacionEventoModel> INSTANCE = new InformacionEventoAssembler();

    private InformacionEventoAssembler() {
        super();
    }

    public static Assembler<InformacionEvento, InformacionEventoModel> getInstance() {
        return INSTANCE;
    }

    @Override
    public InformacionEventoModel toModelFromDomain(InformacionEvento domain) {
        return InformacionEventoModel.create()
                .setId(domain.getId())
                .setDescripcion(domain.getDescripcion())
                .setArtista(domain.getArtista())
                .setGenero(GeneroAssembler.getInstance().toModelFromDomain(domain.getGenero()))
                .setFecha(domain.getFecha());
    }

    @Override
    public InformacionEvento toDomainFromModel(InformacionEventoModel model) {
        return InformacionEvento.create()
                .setId(model.getId())
                .setDescripcion(model.getDescripcion())
                .setArtista(model.getArtista())
                .setGenero(GeneroAssembler.getInstance().toDomainFromModel(model.getGenero()))
                .setFecha(model.getFecha());
    }

    @Override
    public List<InformacionEvento> toDomainListFromModel(List<InformacionEventoModel> modelList) {
        return modelList.stream().map(entity -> toDomainFromModel(entity)).toList();
    }
}
