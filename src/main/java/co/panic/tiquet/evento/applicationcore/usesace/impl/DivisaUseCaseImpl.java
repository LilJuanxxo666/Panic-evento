package co.panic.tiquet.evento.applicationcore.usesace.impl;

import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.panic.tiquet.evento.applicationcore.assembler.concrete.DivisaAssembler;
import co.panic.tiquet.evento.applicationcore.domain.Divisa;
import co.panic.tiquet.evento.applicationcore.usesace.DivisaUseCase;
import co.panic.tiquet.evento.infraestructure.service.DivisaServicio;


@Component
public class DivisaUseCaseImpl implements DivisaUseCase{
	

	@Autowired
	private DivisaServicio divisaServicio;

	@Override
	public Divisa guardar(Divisa divisa) {
		Divisa divisaCreada = Divisa.create().
				setId(UUID.randomUUID()).
				setNombre(divisa.getNombre()).
				setDescripcion(divisa.getDescripcion());
		
		return DivisaAssembler.getInstance().toDomainFromModel(divisaServicio.guardar(DivisaAssembler.getInstance().toModelFromDomain(divisaCreada)));
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
	public Divisa borrar(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Divisa modificar(UUID id, Divisa divisa) {
		// TODO Auto-generated method stub
		return null;

	}
}
