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
    public Boolean borrar(UUID id) {
        if (areaRepositorio.existsById(id)) {
            areaRepositorio.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean modificar(AreaModel area) {
        if (areaRepositorio.existsById(area.getId())) {
            AreaModel areaModificada = new AreaModel(area.getId(), area.getNombre(), area.getDescripcion(), area.getCantAforo(), area.getRangEdad());
            areaRepositorio.save(areaModificada);
            return true;
        } else {
            return false;
        }
    }
}
