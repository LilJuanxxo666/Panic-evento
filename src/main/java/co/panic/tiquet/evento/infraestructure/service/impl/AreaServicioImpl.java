package co.panic.tiquet.evento.infraestructure.service.impl;

import co.panic.tiquet.evento.infraestructure.models.AreaModel;
import co.panic.tiquet.evento.infraestructure.repository.AreaRepositorio;
import co.panic.tiquet.evento.infraestructure.service.AreaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AreaServicioImpl implements AreaServicio {

    @Autowired
    private AreaRepositorio areaRepositorio;

    @Override
    public AreaModel guardar(AreaModel area) {
        return areaRepositorio.save(area);
    }

    @Override
    public AreaModel listarPorID(UUID id) {
        return areaRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<AreaModel> listarTodo() {
        return areaRepositorio.findAll();
    }

    @Override
    public void borrar(UUID id) {
        areaRepositorio.deleteById(id);
    }

    @Override
    public AreaModel modificar(UUID id, AreaModel area) {
        if (!areaRepositorio.existsById(id)) {
            return AreaModel.create();
        } else {
            AreaModel areaModificada = new AreaModel(id, area.getNombre(), area.getDescripcion(), area.getCantAforo(), area.getRangEdad());
            return areaRepositorio.save(areaModificada);
        }
    }
}
