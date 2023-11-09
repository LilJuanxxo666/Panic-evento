package co.panic.tiquet.evento.applicationcore.usesace;

import co.panic.tiquet.evento.applicationcore.domain.InformacionEvento;

import java.util.List;
import java.util.UUID;

public interface InformacionEventoUseCase {

    InformacionEvento guardar(InformacionEvento informacionEvento);

    InformacionEvento listarPorID(UUID id);

    List<InformacionEvento> listarTodo();

    Boolean borrar(UUID id);

    Boolean modificar(InformacionEvento informacionEvento);
}