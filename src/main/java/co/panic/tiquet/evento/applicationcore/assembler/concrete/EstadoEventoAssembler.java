package co.panic.tiquet.evento.applicationcore.assembler.concrete;

import co.panic.tiquet.evento.applicationcore.assembler.Assembler;
import co.panic.tiquet.evento.applicationcore.domain.EstadoEvento;
import co.panic.tiquet.evento.infraestructure.models.EstadoEventoModel;

import java.util.List;

public class EstadoEventoAssembler implements Assembler<EstadoEvento, EstadoEventoModel> {
    private static final Assembler<EstadoEvento, EstadoEventoModel> INSTANCE = new EstadoEventoAssembler();

    private EstadoEventoAssembler() {
        super();
    }

    public static Assembler<EstadoEvento, EstadoEventoModel> getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoEventoModel toModelFromDomain(EstadoEvento domain) {
        return EstadoEventoModel.create()
                .setId(domain.getId())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public EstadoEvento toDomainFromModel(EstadoEventoModel model) {
        return EstadoEvento.create()
                .setId(model.getId())
                .setNombre(model.getNombre())
                .setDescripcion(model.getDescripcion());
    }

    @Override
    public List<EstadoEvento> toDomainListFromModel(List<EstadoEventoModel> modelList) {
        return modelList.stream()
                .map(entity -> toDomainFromModel(entity))
                .toList();
    }
}
