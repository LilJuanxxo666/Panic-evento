package co.panic.tiquet.evento.applicationcore.usesace;

import co.panic.tiquet.evento.applicationcore.domain.Genero;

import java.util.List;
import java.util.UUID;

public interface GeneroUseCase {

    public Genero consultarPorID(UUID id);

    public List<Genero> listarTodo();
}
