package co.panic.tiquet.evento.userinterface.inputadapter.http;

import co.panic.tiquet.evento.applicationcore.domain.Area;
import co.panic.tiquet.evento.applicationcore.usesCase.AreaUseCase;
import co.panic.tiquet.evento.crosscutting.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tiquet/area")
public class AreaApi {

    @Autowired
    AreaUseCase areaUseCase;

    @GetMapping("/dummy")
    public Area dummy() {
        return Area.create();
    }

    @PostMapping
    public ResponseEntity<Area> crearArea(@RequestBody Area area) {
        Area areaCreada = areaUseCase.guardar(area);
        return new ResponseEntity<>(areaCreada, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> consultarAreaPorId(@PathVariable UUID id) {
        Area areaConsultada = areaUseCase.listarPorID(id);
        return new ResponseEntity<>(areaConsultada, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Area>> consultarAreas() {
        List<Area> listaAreas = areaUseCase.listarTodo();
        return new ResponseEntity<>(listaAreas, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> modificarArea(@RequestBody Area area) {
        if (areaUseCase.modificar(area)) {
            return new ResponseEntity<>(Messages.AreaAPI.AREA_UPDATE_OK, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Messages.AreaAPI.ID_AREA_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarArea(@PathVariable UUID id) {
        if (areaUseCase.borrar(id)) {
            return new ResponseEntity<>(Messages.AreaAPI.AREA_DELETE_OK, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Messages.AreaAPI.ID_AREA_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }
}
