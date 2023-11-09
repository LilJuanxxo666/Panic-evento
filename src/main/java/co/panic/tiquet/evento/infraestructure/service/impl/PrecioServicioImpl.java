package co.panic.tiquet.evento.infraestructure.service.impl;

import co.panic.tiquet.evento.infraestructure.models.PrecioModel;
import co.panic.tiquet.evento.infraestructure.repository.PrecioRepositorio;
import co.panic.tiquet.evento.infraestructure.service.PrecioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrecioServicioImpl implements PrecioServicio {

    @Autowired
    private PrecioRepositorio precioRepositorio;

    @Override
    public PrecioModel guardar(PrecioModel precio) {
        return precioRepositorio.save(precio);
    }

    @Override
    public PrecioModel listarPorID(UUID id) {
        PrecioModel precioCreado = precioRepositorio.findById(id).orElse(null);
        return precioCreado;
    }

    @Override
    public List<PrecioModel> listarTodo() {
        return precioRepositorio.findAll();
    }

    @Override
    public Boolean borrar(UUID id) {
        if (precioRepositorio.existsById(id)) {
            precioRepositorio.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean modificar(PrecioModel precio) {
        if (precioRepositorio.existsById(precio.getId())) {
            PrecioModel precioCreado = new PrecioModel(precio.getId(), precio.getPrecio(), precio.getDivisa());
            precioRepositorio.save(precioCreado);
            return true;
        } else {
            return false;
        }
    }
}
