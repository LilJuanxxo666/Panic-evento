package co.panic.tiquet.evento.userinterface.inputadapter.http;

import co.panic.tiquet.evento.applicationcore.domain.EstadoEvento;
import co.panic.tiquet.evento.applicationcore.usesCace.EstadoEventoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tiquet/estadoEvento")
public class EstadoEventoApi {

    @Autowired
    EstadoEventoUseCase estadoEventoUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<EstadoEvento> consultarEstadoEventoPorId(@PathVariable UUID id) {
        EstadoEvento estadoEvento = estadoEventoUseCase.consultarPorID(id);
        if (estadoEvento != null) {
            return new ResponseEntity<>(estadoEvento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<EstadoEvento>> ConsultarEstadoEvento() {
        List<EstadoEvento> listaEstadoEvento = estadoEventoUseCase.listarTodo();
        return new ResponseEntity<>(listaEstadoEvento, HttpStatus.OK);
    }
}
