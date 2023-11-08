package co.panic.tiquet.evento.applicationcore.usesace;

import co.panic.tiquet.evento.applicationcore.domain.Area;

import java.util.List;
import java.util.UUID;

public interface AreaUseCase {

    public Area guardar(Area area);

    public Area listarPorID(UUID id);

    public List<Area> listarTodo();

    public Area borrar(UUID id);

    public Area modificar(UUID id, Area area);
}