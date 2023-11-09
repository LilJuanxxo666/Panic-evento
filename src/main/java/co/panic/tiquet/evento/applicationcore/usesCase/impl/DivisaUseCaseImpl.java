package co.panic.tiquet.evento.applicationcore.usesCase.impl;

import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.panic.tiquet.evento.applicationcore.assembler.concrete.DivisaAssembler;
import co.panic.tiquet.evento.applicationcore.domain.Divisa;
import co.panic.tiquet.evento.applicationcore.usesCase.DivisaUseCase;
import co.panic.tiquet.evento.infraestructure.models.DivisaModel;
import co.panic.tiquet.evento.infraestructure.service.DivisaServicio;


@Component
public class DivisaUseCaseImpl implements DivisaUseCase{
	
	@Autowired
	private DivisaServicio divisaServicio;

	@Override
	public Divisa guardar(Divisa divisa) {
		DivisaModel divisaCreada = DivisaModel.create().
				setId(UUID.randomUUID()).
				setNombre(divisa.getNombre()).
				setDescripcion(divisa.getDescripcion());
		
		return DivisaAssembler.getInstance().toDomainFromModel(divisaServicio.guardar(divisaCreada));
	}

	@Override
	public Divisa listarPorID(UUID id) {
		return DivisaAssembler.getInstance().toDomainFromModel(divisaServicio.listarPorID(id));
	}

	@Override
	public List<Divisa> listarTodo() {
		return DivisaAssembler.getInstance().toDomainListFromModel(divisaServicio.listarTodo());
	}

	@Override
	public Boolean borrar(UUID id) {
		return divisaServicio.borrar(id);
	}

	@Override
	public Boolean modificar(Divisa divisa) {
		DivisaModel divisaCreada = DivisaModel.create().
				setId(divisa.getId()).
				setNombre(divisa.getNombre()).
				setDescripcion(divisa.getDescripcion());
		return divisaServicio.modificar(divisaCreada);
	}
}
