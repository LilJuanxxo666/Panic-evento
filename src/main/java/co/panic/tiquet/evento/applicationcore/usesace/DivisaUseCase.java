package co.panic.tiquet.evento.applicationcore.usesace;

import java.util.List;
import java.util.UUID;

import co.panic.tiquet.evento.applicationcore.domain.Divisa;

public interface DivisaUseCase {

	public Divisa guardar(Divisa divisa);
	
	public Divisa listarPorID(UUID id);
	
	public List<Divisa> listarTodo();
	
	public Divisa borrar(UUID id);
	
	public Divisa modificar(UUID id, Divisa divisa);
}
