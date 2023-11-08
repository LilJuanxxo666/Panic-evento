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
	public void borrar(UUID id) {
		divisaRepositorio.deleteById(id);
	}

	@Override
	public DivisaModel modificar(UUID id, DivisaModel divisa) {
		if(!divisaRepositorio.existsById(id)) {
			return DivisaModel.create();
		}else {
			DivisaModel divisaCreada = new DivisaModel(id, divisa.getNombre(), divisa.getDescripcion());
			return divisaRepositorio.save(divisaCreada);
			
		}
	}
}
