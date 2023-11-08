package co.panic.tiquet.evento.infraestructure.service;

import java.util.List;
import java.util.UUID;

import co.panic.tiquet.evento.infraestructure.models.DivisaModel;

public interface DivisaServicio {

	public DivisaModel guardar(DivisaModel divisa);
	
	public DivisaModel listarPorID(UUID id);
	
	public List<DivisaModel> listarTodo();
	
	public void borrar(UUID id);
	
	public DivisaModel modificar(UUID id, DivisaModel divisa);
}
