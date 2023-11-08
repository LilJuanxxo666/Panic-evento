package co.panic.tiquet.evento.applicationcore.usesace;

import co.panic.tiquet.evento.applicationcore.domain.EstadoEvento;

import java.util.List;
import java.util.UUID;

public interface EstadoEventoUseCase {

    public EstadoEvento consultarPorID(UUID id);

    public List<EstadoEvento> listarTodo();
}
