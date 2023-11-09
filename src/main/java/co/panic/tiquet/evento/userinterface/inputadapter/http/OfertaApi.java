package co.panic.tiquet.evento.userinterface.inputadapter.http;

import co.panic.tiquet.evento.applicationcore.domain.Oferta;
import co.panic.tiquet.evento.applicationcore.usesCase.OfertaUseCase;
import co.panic.tiquet.evento.crosscutting.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tiquet/oferta")
public class OfertaApi {

    @Autowired
    OfertaUseCase ofertaUseCase;

    @GetMapping("/dummy")
    public Oferta dummy() {
        return Oferta.create();
    }

    @PostMapping
    public ResponseEntity<Oferta> crearOferta(@RequestBody Oferta oferta) {
        Oferta ofertaCreada = ofertaUseCase.guardar(oferta);
        return new ResponseEntity<>(ofertaCreada, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oferta> consultarOfertaPorId(@PathVariable UUID id) {
        Oferta ofertaCreada = ofertaUseCase.listarPorID(id);
        return new ResponseEntity<>(ofertaCreada, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Oferta>> consultarOfertas() {
        List<Oferta> listaOfertaCreadas = ofertaUseCase.listarTodo();
        return new ResponseEntity<>(listaOfertaCreadas, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> modificarOferta(@RequestBody Oferta oferta) {
        if (ofertaUseCase.modificar(oferta)) {
            return new ResponseEntity<>(Messages.OfertaAPI.OFERTA_UPDATE_OK, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Messages.OfertaAPI.ID_OFERTA_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOferta(@PathVariable UUID id) {
        if (ofertaUseCase.borrar(id)) {
            return new ResponseEntity<>(Messages.OfertaAPI.OFERTA_DELETE_OK, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Messages.OfertaAPI.ID_OFERTA_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }
}
