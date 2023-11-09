package co.panic.tiquet.evento.applicationcore.usesace;

import co.panic.tiquet.evento.applicationcore.domain.Evento;

import java.util.List;
import java.util.UUID;

public interface EventoUseCase {

    Evento guardar(Evento evento);

    Evento listarPorID(UUID id);

    List<Evento> listarTodo();

    Boolean borrar(UUID id);

    Boolean modificar(Evento evento);
}