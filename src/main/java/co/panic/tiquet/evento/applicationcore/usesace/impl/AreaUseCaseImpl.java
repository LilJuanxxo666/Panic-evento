package co.panic.tiquet.evento.applicationcore.usesace.impl;

import co.panic.tiquet.evento.applicationcore.assembler.concrete.AreaAssembler;
import co.panic.tiquet.evento.applicationcore.domain.Area;
import co.panic.tiquet.evento.applicationcore.usesace.AreaUseCase;
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
        Area areaCreada = Area.create()
                .setId(UUID.randomUUID())
                .setNombre(area.getNombre())
                .setDescripcion(area.getDescripcion())
                .setCantAforo(area.getCantAforo())
                .setRangEdad(area.getRangEdad());

        return AreaAssembler.getInstance().toDomainFromModel(areaServicio.guardar(AreaAssembler.getInstance().toModelFromDomain(areaCreada)));
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
    public Area borrar(UUID id) {
        return null;
    }

    @Override
    public Area modificar(UUID id, Area area) {
        return null;
    }
}
