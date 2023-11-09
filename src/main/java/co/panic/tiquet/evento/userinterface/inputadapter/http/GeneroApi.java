package co.panic.tiquet.evento.userinterface.inputadapter.http;

import co.panic.tiquet.evento.applicationcore.domain.Genero;
import co.panic.tiquet.evento.applicationcore.usesCase.GeneroUseCase;
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
@RequestMapping("tiquet/genero")
public class GeneroApi {

    @Autowired
    GeneroUseCase generoUseCase;

    @GetMapping("/dummy")
    public Genero dummy() {
        return Genero.create();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> consultarGeneroPorId(@PathVariable UUID id) {
        Genero genero = generoUseCase.consultarPorID(id);
        if (genero != null) {
            return new ResponseEntity<>(genero, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Genero>> consultarGenero() {
        List<Genero> listaGenero = generoUseCase.listarTodo();
        return new ResponseEntity<>(listaGenero, HttpStatus.OK);
    }
}