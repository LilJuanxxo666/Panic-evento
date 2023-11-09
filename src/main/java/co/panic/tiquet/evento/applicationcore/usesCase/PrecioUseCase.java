package co.panic.tiquet.evento.applicationcore.usesCase;

import co.panic.tiquet.evento.applicationcore.domain.Precio;

import java.util.List;
import java.util.UUID;

public interface PrecioUseCase {

    Precio guardar(Precio precio);

    Precio listarPorID(UUID id);

    List<Precio> listarTodo();

    Boolean borrar(UUID id);

    Boolean modificar(Precio precio);
}
