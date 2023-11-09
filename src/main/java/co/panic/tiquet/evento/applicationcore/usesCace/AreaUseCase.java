package co.panic.tiquet.evento.applicationcore.usesCace;

import co.panic.tiquet.evento.applicationcore.domain.Area;

import java.util.List;
import java.util.UUID;

public interface AreaUseCase {

    public Area guardar(Area area);

    public Area listarPorID(UUID id);

    public List<Area> listarTodo();

    public Boolean borrar(UUID id);

    public Boolean modificar(Area area);
}