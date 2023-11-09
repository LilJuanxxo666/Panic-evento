package co.panic.tiquet.evento.userinterface.inputadapter.http;

import co.panic.tiquet.evento.applicationcore.domain.Precio;
import co.panic.tiquet.evento.applicationcore.usesCace.PrecioUseCase;
import co.panic.tiquet.evento.crosscutting.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tiquet/precio")
public class PrecioApi {

    @Autowired
    PrecioUseCase precioUseCase;

    @GetMapping("/dummy")
    public Precio dummy() {
        return Precio.create();
    }

    @PostMapping
    public ResponseEntity<Precio> crearPrecio(@RequestBody Precio precio) {
        Precio precioCreado = precioUseCase.guardar(precio);
        return new ResponseEntity<>(precioCreado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Precio> consultarPrecioPorId(@PathVariable UUID id) {
        Precio precioCreado = precioUseCase.listarPorID(id);
        return new ResponseEntity<>(precioCreado, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Precio>> consultarPrecios() {
        List<Precio> listaPrecioCreados = precioUseCase.listarTodo();
        return new ResponseEntity<>(listaPrecioCreados, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> modificarPrecio(@RequestBody Precio precio) {
        if (precioUseCase.modificar(precio)) {
            return new ResponseEntity<>(Messages.PrecioAPI.PRECIO_UPDATE_OK, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Messages.PrecioAPI.ID_PRECIO_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPrecio(@PathVariable UUID id) {
        if (precioUseCase.borrar(id)) {
            return new ResponseEntity<>(Messages.PrecioAPI.PRECIO_DELETE_OK, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Messages.PrecioAPI.ID_PRECIO_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }
}
