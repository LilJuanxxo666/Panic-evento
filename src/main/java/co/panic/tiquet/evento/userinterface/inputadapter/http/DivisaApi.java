package co.panic.tiquet.evento.userinterface.inputadapter.http;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.panic.tiquet.evento.applicationcore.domain.Divisa;
import co.panic.tiquet.evento.applicationcore.usesace.DivisaUseCase;

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
    /*@PostMapping(value = "create", produces=MediaType.APPLICATION_JSON_VALUE)
    public Divisa create( @RequestParam String nombre, @RequestParam String descripcion) {
        return divisaInputPort.createDivisa(nombre, descripcion);
        }
 
    @PostMapping(value = "get", produces=MediaType.APPLICATION_JSON_VALUE)
    public Divisa get( @RequestParam String divisaId ) {
        return divisaInputPort.getById(divisaId);
        }

    @PostMapping(value = "getall", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Divisa> getAll() {
        return divisaInputPort.getAll();
        }
    */
           
}
