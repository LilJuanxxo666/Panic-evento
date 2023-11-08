package co.panic.tiquet.evento.applicationcore.assembler.concrete;

import co.panic.tiquet.evento.applicationcore.assembler.Assembler;
import co.panic.tiquet.evento.applicationcore.domain.Genero;
import co.panic.tiquet.evento.infraestructure.models.GeneroModel;

import java.util.List;

public class GeneroAssembler implements Assembler<Genero, GeneroModel> {
    private static final Assembler<Genero, GeneroModel> INSTANCE = new GeneroAssembler();

    private GeneroAssembler() {
        super();
    }

    public static Assembler<Genero, GeneroModel> getInstance() {
        return INSTANCE;
    }

    @Override
    public GeneroModel toModelFromDomain(Genero domain) {
        return GeneroModel.create()
                .setId(domain.getId())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public Genero toDomainFromModel(GeneroModel model) {
        return Genero.create()
                .setId(model.getId())
                .setNombre(model.getNombre())
                .setDescripcion(model.getDescripcion());
    }

    @Override
    public List<Genero> toDomainListFromModel(List<GeneroModel> modelList) {
        return modelList.stream()
                .map(entity -> toDomainFromModel(entity))
                .toList();
    }
}