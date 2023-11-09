package co.panic.tiquet.evento.applicationcore.usesCase;

import co.panic.tiquet.evento.applicationcore.domain.Oferta;

import java.util.List;
import java.util.UUID;

public interface OfertaUseCase {

    Oferta guardar(Oferta oferta);

    Oferta listarPorID(UUID id);

    List<Oferta> listarTodo();

    Boolean borrar(UUID id);

    Boolean modificar(Oferta oferta);
}
