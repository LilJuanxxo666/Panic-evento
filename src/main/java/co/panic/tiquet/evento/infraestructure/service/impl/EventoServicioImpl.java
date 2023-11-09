package co.panic.tiquet.evento.infraestructure.service.impl;

import co.panic.tiquet.evento.infraestructure.models.EventoModel;
import co.panic.tiquet.evento.infraestructure.repository.EventoRepositorio;
import co.panic.tiquet.evento.infraestructure.service.EventoServicio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EventoServicioImpl implements EventoServicio {

    @Autowired
    private EventoRepositorio eventoRepositorio;

    @Override
    public EventoModel guardar(EventoModel evento) {
        return eventoRepositorio.save(evento);
    }

    @Override
    public EventoModel listarPorID(UUID id) {
        return eventoRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<EventoModel> listarTodo() {
        return eventoRepositorio.findAll();
    }

    @Override
    public Boolean borrar(UUID id) {
        if (eventoRepositorio.existsById(id)) {
            eventoRepositorio.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean modificar(EventoModel evento) {
        if (eventoRepositorio.existsById(evento.getId())) {
            eventoRepositorio.save(evento);
            return true;
        } else {
            return false;
        }
    }
}
