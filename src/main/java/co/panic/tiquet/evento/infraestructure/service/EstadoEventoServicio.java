package co.panic.tiquet.evento.infraestructure.service;

import co.panic.tiquet.evento.infraestructure.models.EstadoEventoModel;

import java.util.List;
import java.util.UUID;

public interface EstadoEventoServicio {

    EstadoEventoModel listarPorID(UUID id);

    List<EstadoEventoModel> listarTodo();
}
