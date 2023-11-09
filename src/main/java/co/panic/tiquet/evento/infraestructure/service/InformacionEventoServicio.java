package co.panic.tiquet.evento.infraestructure.service;

import co.panic.tiquet.evento.infraestructure.models.InformacionEventoModel;

import java.util.List;
import java.util.UUID;

public interface InformacionEventoServicio {

    InformacionEventoModel guardar(InformacionEventoModel informacionEvento);

    InformacionEventoModel listarPorID(UUID id);

    List<InformacionEventoModel> listarTodo();

    Boolean borrar(UUID id);

    Boolean modificar(InformacionEventoModel informacionEvento);
}