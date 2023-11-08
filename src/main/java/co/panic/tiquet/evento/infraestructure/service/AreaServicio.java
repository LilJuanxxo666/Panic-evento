package co.panic.tiquet.evento.infraestructure.service;

import co.panic.tiquet.evento.infraestructure.models.AreaModel;

import java.util.List;
import java.util.UUID;

public interface AreaServicio {

    AreaModel guardar(AreaModel area);

    AreaModel listarPorID(UUID id);

    List<AreaModel> listarTodo();

    void borrar(UUID id);

    AreaModel modificar(UUID id, AreaModel area);
}
