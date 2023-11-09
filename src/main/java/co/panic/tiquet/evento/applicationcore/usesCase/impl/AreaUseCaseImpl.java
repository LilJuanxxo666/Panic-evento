package co.panic.tiquet.evento.applicationcore.usesCase.impl;

import co.panic.tiquet.evento.applicationcore.assembler.concrete.AreaAssembler;
import co.panic.tiquet.evento.applicationcore.domain.Area;
import co.panic.tiquet.evento.applicationcore.usesCase.AreaUseCase;
import co.panic.tiquet.evento.infraestructure.models.AreaModel;
import co.panic.tiquet.evento.infraestructure.service.AreaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AreaUseCaseImpl implements AreaUseCase {

    @Autowired
    private AreaServicio areaServicio;

    @Override
    public Area guardar(Area area) {
        AreaModel areaCreada = AreaModel.create()
                .setId(UUID.randomUUID())
                .setNombre(area.getNombre())
                .setDescripcion(area.getDescripcion())
                .setCantAforo(area.getCantAforo())
                .setRangEdad(area.getRangEdad());

        return AreaAssembler.getInstance().toDomainFromModel(areaServicio.guardar(areaCreada));
    }

    @Override
    public Area listarPorID(UUID id) {
        return AreaAssembler.getInstance().toDomainFromModel(areaServicio.listarPorID(id));
    }

    @Override
    public List<Area> listarTodo() {
        return AreaAssembler.getInstance().toDomainListFromModel(areaServicio.listarTodo());
    }

    @Override
    public Boolean borrar(UUID id) {
        return areaServicio.borrar(id);

    }

    @Override
    public Boolean modificar(Area area) {
        AreaModel areaModificada = AreaModel.create()
                .setId(area.getId())
                .setNombre(area.getNombre())
                .setDescripcion(area.getDescripcion())
                .setCantAforo(area.getCantAforo())
                .setRangEdad(area.getRangEdad());

        return areaServicio.modificar(areaModificada);
    }
}
