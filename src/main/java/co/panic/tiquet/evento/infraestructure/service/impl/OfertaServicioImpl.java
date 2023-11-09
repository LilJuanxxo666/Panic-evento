package co.panic.tiquet.evento.infraestructure.service.impl;

import co.panic.tiquet.evento.infraestructure.models.OfertaModel;
import co.panic.tiquet.evento.infraestructure.repository.OfertaRepositorio;
import co.panic.tiquet.evento.infraestructure.service.OfertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OfertaServicioImpl implements OfertaServicio {

    @Autowired
    private OfertaRepositorio ofertaRepositorio;

    @Override
    public OfertaModel guardar(OfertaModel oferta) {
        return ofertaRepositorio.save(oferta);
    }

    @Override
    public OfertaModel listarPorID(UUID id) {
        return ofertaRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<OfertaModel> listarTodo() {
        return ofertaRepositorio.findAll();
    }

    @Override
    public Boolean borrar(UUID id) {
        if (ofertaRepositorio.existsById(id)) {
            ofertaRepositorio.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean modificar(OfertaModel oferta) {
        if (ofertaRepositorio.existsById(oferta.getId())) {
            OfertaModel ofertaCreada = new OfertaModel(oferta.getId(), oferta.getNombre(), oferta.getDescripcion(), oferta.getPrecio(), oferta.getArea());
            ofertaRepositorio.save(ofertaCreada);
            return true;
        } else {
            return false;
        }
    }
}
