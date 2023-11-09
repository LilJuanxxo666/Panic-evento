package co.panic.tiquet.evento.applicationcore.usesCase;

import java.util.List;
import java.util.UUID;

import co.panic.tiquet.evento.applicationcore.domain.Divisa;

public interface DivisaUseCase {

	public Divisa guardar(Divisa divisa);
	
	public Divisa listarPorID(UUID id);
	
	public List<Divisa> listarTodo();
	
	public Boolean borrar(UUID id);
	
	public Boolean modificar(Divisa divisa);
}
