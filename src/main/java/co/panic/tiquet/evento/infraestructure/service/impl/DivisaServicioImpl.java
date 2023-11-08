package co.panic.tiquet.evento.infraestructure.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.panic.tiquet.evento.infraestructure.models.DivisaModel;
import co.panic.tiquet.evento.infraestructure.repository.DivisaRepositorio;
import co.panic.tiquet.evento.infraestructure.service.DivisaServicio;

@Service
public class DivisaServicioImpl implements DivisaServicio{

	@Autowired
	private DivisaRepositorio divisaRepositorio;

	@Override
	public DivisaModel guardar(DivisaModel divisa) {
		return divisaRepositorio.save(divisa);
	}

	@Override
	public DivisaModel listarPorID(UUID id) {
		DivisaModel divisaCreada = divisaRepositorio.findById(id).get();
		return divisaCreada;
	}

	@Override
	public List<DivisaModel> listarTodo() {
		List<DivisaModel> listaCreada = divisaRepositorio.findAll();
		return listaCreada;
	}

	@Override
	public Boolean borrar(UUID id) {
		if(divisaRepositorio.existsById(id)) {
			divisaRepositorio.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Boolean modificar(DivisaModel divisa) {
		if(divisaRepositorio.existsById(divisa.getId())) {
			DivisaModel divisaCreada = new DivisaModel(divisa.getId(), divisa.getNombre(), divisa.getDescripcion());
			divisaRepositorio.save(divisaCreada);
			return true;
		}else {
			return false;
		}
		
	}
}
