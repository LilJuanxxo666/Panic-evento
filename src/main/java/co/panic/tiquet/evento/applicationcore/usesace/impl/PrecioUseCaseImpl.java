package co.panic.tiquet.evento.applicationcore.usesace.impl;

import co.panic.tiquet.evento.applicationcore.assembler.concrete.DivisaAssembler;
import co.panic.tiquet.evento.applicationcore.assembler.concrete.PrecioAssembler;
import co.panic.tiquet.evento.applicationcore.domain.Precio;
import co.panic.tiquet.evento.applicationcore.usesace.PrecioUseCase;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;
import co.panic.tiquet.evento.infraestructure.models.PrecioModel;
import co.panic.tiquet.evento.infraestructure.repository.PrecioRepositorio;
import co.panic.tiquet.evento.infraestructure.service.PrecioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PrecioUseCaseImpl implements PrecioUseCase {

    @Autowired
    private PrecioServicio precioServicio;
    
    @Autowired
    private PrecioRepositorio precioRepositorio;

    @Override
    public Precio guardar(Precio precio) {
    	
    	UUID id;
    	
    	do {
			id = UtilUUID.generateNewUUID();
		}while(precioRepositorio.existsById(id));
    	
    	
        PrecioModel precioCreado = PrecioModel.create()
                .setId(UUID.randomUUID())
                .setPrecio(precio.getPrecio())
                .setDivisa(DivisaAssembler.getInstance().toModelFromDomain(precio.getDivisa()));

        return PrecioAssembler.getInstance().toDomainFromModel(precioServicio.guardar(precioCreado));
    }

    @Override
    public Precio listarPorID(UUID id) {
        return PrecioAssembler.getInstance().toDomainFromModel(precioServicio.listarPorID(id));
    }

    @Override
    public List<Precio> listarTodo() {
        return PrecioAssembler.getInstance().toDomainListFromModel(precioServicio.listarTodo());
    }

    @Override
    public Boolean borrar(UUID id) {
        return precioServicio.borrar(id);
    }

    @Override
    public Boolean modificar(Precio precio) {
        PrecioModel precioCreado = PrecioModel.create()
                .setId(precio.getId())
                .setPrecio(precio.getPrecio())
                .setDivisa(DivisaAssembler.getInstance().toModelFromDomain(precio.getDivisa()));
        return precioServicio.modificar(precioCreado);
    }
}
