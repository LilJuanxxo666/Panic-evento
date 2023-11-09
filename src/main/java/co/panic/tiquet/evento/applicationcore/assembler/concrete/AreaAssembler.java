package co.panic.tiquet.evento.applicationcore.assembler.concrete;

import co.panic.tiquet.evento.applicationcore.assembler.Assembler;
import co.panic.tiquet.evento.applicationcore.domain.Area;
import co.panic.tiquet.evento.infraestructure.models.AreaModel;

import java.util.List;

public class AreaAssembler implements Assembler<Area, AreaModel> {

    private static final Assembler<Area, AreaModel> INSTANCE = new AreaAssembler();

    private AreaAssembler() {
        super();
    }

    public static Assembler<Area, AreaModel> getInstance() {
        return INSTANCE;
    }

    @Override
    public AreaModel toModelFromDomain(Area domain) {
        return AreaModel.create()
                .setId(domain.getId())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion())
                .setCantAforo(domain.getCantAforo())
                .setRangEdad(domain.getRangEdad());
    }

    @Override
    public Area toDomainFromModel(AreaModel model) {
        return Area.create()
                .setId(model.getId())
                .setNombre(model.getNombre())
                .setDescripcion(model.getDescripcion())
                .setCantAforo(model.getCantAforo())
                .setRangEdad(model.getRangEdad());
    }

    @Override
    public List<Area> toDomainListFromModel(List<AreaModel> modelList) {
        return modelList.stream().map(entity -> toDomainFromModel(entity)).toList();
    }
}
