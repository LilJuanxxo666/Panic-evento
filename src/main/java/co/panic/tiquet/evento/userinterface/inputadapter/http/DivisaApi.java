package co.panic.tiquet.evento.userinterface.inputadapter.http;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.panic.tiquet.evento.applicationcore.domain.Divisa;
import co.panic.tiquet.evento.applicationcore.usesCace.DivisaUseCase;
import co.panic.tiquet.evento.crosscutting.utils.Messages;

@RestController
@RequestMapping("tiquet/divisa")
public class DivisaApi {
	
    @Autowired
    DivisaUseCase divisaUseCase;
    
	@GetMapping("/dummy")
	public Divisa dummy() {
		return Divisa.create();
	}

	@PostMapping
	public ResponseEntity<Divisa> crearDivisa(@RequestBody Divisa divisa){
		Divisa divisaCreada = divisaUseCase.guardar(divisa);
		return new ResponseEntity<>(divisaCreada, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Divisa> consultarDivisaPorId(@PathVariable UUID id){
		Divisa divisaCreada = divisaUseCase.listarPorID(id);
		return new ResponseEntity<>(divisaCreada, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Divisa>> consultarDivisa(){
		List<Divisa> listaDivisaCreada = divisaUseCase.listarTodo();
		return new ResponseEntity<>(listaDivisaCreada, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> modificarDivisa(@RequestBody Divisa divisa){
		if(divisaUseCase.modificar(divisa)) {
			return new ResponseEntity<>(Messages.DivisaAPI.DIVISA_UPDATE_OK, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(Messages.DivisaAPI.ID_DIVISA_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarDivisa(@PathVariable UUID id){ 
		if(divisaUseCase.borrar(id)) {
			return new ResponseEntity<>(Messages.DivisaAPI.DIVISA_DELETE_OK, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(Messages.DivisaAPI.ID_DIVISA_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
	}           
}
