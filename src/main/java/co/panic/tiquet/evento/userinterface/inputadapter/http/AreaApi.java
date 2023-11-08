package co.panic.tiquet.evento.userinterface.inputadapter.http;

import co.panic.tiquet.evento.applicationcore.domain.Area;
import co.panic.tiquet.evento.applicationcore.usesace.AreaUseCase;
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
}