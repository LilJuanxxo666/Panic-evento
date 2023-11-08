package co.panic.tiquet.evento.infraestructure.service;

import co.panic.tiquet.evento.infraestructure.models.GeneroModel;

import java.util.List;
import java.util.UUID;

public interface GeneroServicio {

    public GeneroModel consultarPorID(UUID id);

    public List<GeneroModel> listarTodo();
}
