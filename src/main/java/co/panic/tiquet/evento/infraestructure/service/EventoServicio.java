package co.panic.tiquet.evento.infraestructure.service;


import co.panic.tiquet.evento.infraestructure.models.EventoModel;

import java.util.List;
import java.util.UUID;

public interface EventoServicio {

    EventoModel guardar(EventoModel evento);

    EventoModel listarPorID(UUID id);

    List<EventoModel> listarTodo();

    Boolean borrar(UUID id);

    Boolean modificar(EventoModel evento);
}

