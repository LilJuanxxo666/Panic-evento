package co.panic.tiquet.evento.userinterface.inputadapter.http;

import co.panic.tiquet.evento.applicationcore.domain.InformacionEvento;
import co.panic.tiquet.evento.applicationcore.usesace.InformacionEventoUseCase;
import co.panic.tiquet.evento.crosscutting.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tiquet/informacion-evento")
public class InformacionEventoApi {

    @Autowired
    InformacionEventoUseCase informacionEventoUseCase;

    @GetMapping("/dummy")
    public InformacionEvento dummy() {
        return InformacionEvento.create();
    }

    @PostMapping
    public ResponseEntity<InformacionEvento> crearInformacionEvento(@RequestBody InformacionEvento informacionEvento) {
        InformacionEvento informacionEventoCreada = informacionEventoUseCase.guardar(informacionEvento);
        return new ResponseEntity<>(informacionEventoCreada, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformacionEvento> consultarInformacionEventoPorId(@PathVariable UUID id) {
        InformacionEvento informacionEventoConsultada = informacionEventoUseCase.listarPorID(id);
        return new ResponseEntity<>(informacionEventoConsultada, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<InformacionEvento>> consultarInformacionEventos() {
        List<InformacionEvento> listaInformacionEventos = informacionEventoUseCase.listarTodo();
        return new ResponseEntity<>(listaInformacionEventos, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> modificarInformacionEvento(@RequestBody InformacionEvento informacionEvento) {
        if (informacionEventoUseCase.modificar(informacionEvento)) {
            return new ResponseEntity<>(Messages.InformacionEventoAPI.INFORMACION_EVENTO_UPDATE_OK, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Messages.InformacionEventoAPI.ID_INFORMACION_EVENTO_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarInformacionEvento(@PathVariable UUID id) {
        if (informacionEventoUseCase.borrar(id)) {
            return new ResponseEntity<>(Messages.InformacionEventoAPI.INFORMACION_EVENTO_DELETE_OK, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Messages.InformacionEventoAPI.ID_INFORMACION_EVENTO_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }
}