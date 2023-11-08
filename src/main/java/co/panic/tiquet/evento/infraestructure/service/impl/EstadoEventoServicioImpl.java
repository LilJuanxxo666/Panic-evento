package co.panic.tiquet.evento.infraestructure.service.impl;

import co.panic.tiquet.evento.infraestructure.models.EstadoEventoModel;
import co.panic.tiquet.evento.infraestructure.repository.EstadoEventoRepositorio;
import co.panic.tiquet.evento.infraestructure.service.EstadoEventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class EstadoEventoServicioImpl implements EstadoEventoServicio {

    @Autowired
    private EstadoEventoRepositorio estadoEventoRepositorio;

    @Override
    public EstadoEventoModel listarPorID(UUID id) {
        return estadoEventoRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<EstadoEventoModel> listarTodo() {
        return estadoEventoRepositorio.findAll();
    }
}
