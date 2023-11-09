package co.panic.tiquet.evento.infraestructure.service.impl;

import co.panic.tiquet.evento.infraestructure.models.InformacionEventoModel;
import co.panic.tiquet.evento.infraestructure.repository.InformacionEventoRepositorio;
import co.panic.tiquet.evento.infraestructure.service.InformacionEventoServicio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class InformacionEventoServicioImpl implements InformacionEventoServicio {

    @Autowired
    private InformacionEventoRepositorio informacionEventoRepositorio;

    @Override
    public InformacionEventoModel guardar(InformacionEventoModel informacionEvento) {
        return informacionEventoRepositorio.save(informacionEvento);
    }

    @Override
    public InformacionEventoModel listarPorID(UUID id) {
        return informacionEventoRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<InformacionEventoModel> listarTodo() {
        return informacionEventoRepositorio.findAll();
    }

    @Override
    public Boolean borrar(UUID id) {
        if (informacionEventoRepositorio.existsById(id)) {
            informacionEventoRepositorio.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean modificar(InformacionEventoModel informacionEvento) {
        if (informacionEventoRepositorio.existsById(informacionEvento.getId())) {
            informacionEventoRepositorio.save(informacionEvento);
            return true;
        } else {
            return false;
        }
    }
}