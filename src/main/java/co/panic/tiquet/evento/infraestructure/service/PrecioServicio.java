package co.panic.tiquet.evento.infraestructure.service;

import co.panic.tiquet.evento.infraestructure.models.PrecioModel;

import java.util.List;
import java.util.UUID;

public interface PrecioServicio {

    PrecioModel guardar(PrecioModel precio);

    PrecioModel listarPorID(UUID id);

    List<PrecioModel> listarTodo();

    Boolean borrar(UUID id);

    Boolean modificar(PrecioModel precio);
}
