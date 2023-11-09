package co.panic.tiquet.evento.userinterface.inputadapter.http;

import co.panic.tiquet.evento.applicationcore.domain.Evento;
import co.panic.tiquet.evento.applicationcore.usesace.EventoUseCase;
import co.panic.tiquet.evento.crosscutting.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tiquet/evento")
public class EventoApi {

    @Autowired
    EventoUseCase eventoUseCase;

    @GetMapping("/dummy")
    public Evento dummy() {
        return Evento.create();
    }

    @PostMapping
    public ResponseEntity<Evento> crearEvento(@RequestBody Evento evento) {
        Evento eventoCreado = eventoUseCase.guardar(evento);
        return new ResponseEntity<>(eventoCreado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> consultarEventoPorId(@PathVariable UUID id) {
        Evento eventoConsultado = eventoUseCase.listarPorID(id);
        return new ResponseEntity<>(eventoConsultado, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> consultarEventos() {
        List<Evento> listaEventos = eventoUseCase.listarTodo();
        return new ResponseEntity<>(listaEventos, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> modificarEvento(@RequestBody Evento evento) {
        if (eventoUseCase.modificar(evento)) {
            return new ResponseEntity<>(Messages.EventoAPI.EVENTO_UPDATE_OK, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Messages.EventoAPI.ID_EVENTO_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEvento(@PathVariable UUID id) {
        if (eventoUseCase.borrar(id)) {
            return new ResponseEntity<>(Messages.EventoAPI.EVENTO_DELETE_OK, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Messages.EventoAPI.ID_EVENTO_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }
}
