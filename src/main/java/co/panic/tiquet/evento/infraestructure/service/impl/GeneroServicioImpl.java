package co.panic.tiquet.evento.infraestructure.service.impl;

import co.panic.tiquet.evento.infraestructure.models.GeneroModel;
import co.panic.tiquet.evento.infraestructure.repository.GeneroRepositorio;
import co.panic.tiquet.evento.infraestructure.service.GeneroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GeneroServicioImpl implements GeneroServicio {

    @Autowired
    private GeneroRepositorio generoRepositorio;

    @Override
    public GeneroModel consultarPorID(UUID id) {
        GeneroModel genero = generoRepositorio.findById(id).orElse(null);
        return genero;
    }

    @Override
    public List<GeneroModel> listarTodo() {
        List<GeneroModel> listaGeneros = generoRepositorio.findAll();
        return listaGeneros;
    }
}
