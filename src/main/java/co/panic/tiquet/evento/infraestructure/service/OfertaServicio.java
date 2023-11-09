package co.panic.tiquet.evento.infraestructure.service;

import co.panic.tiquet.evento.infraestructure.models.OfertaModel;

import java.util.List;
import java.util.UUID;

public interface OfertaServicio {

    OfertaModel guardar(OfertaModel oferta);

    OfertaModel listarPorID(UUID id);

    List<OfertaModel> listarTodo();

    Boolean borrar(UUID id);

    Boolean modificar(OfertaModel oferta);
}