package co.panic.tiquet.evento.applicationcore.assembler.concrete;

import co.panic.tiquet.evento.applicationcore.assembler.Assembler;
import co.panic.tiquet.evento.applicationcore.domain.Precio;
import co.panic.tiquet.evento.infraestructure.models.PrecioModel;

import java.util.List;

public class PrecioAssembler implements Assembler<Precio, PrecioModel> {

    private static final Assembler<Precio, PrecioModel> INSTANCE = new PrecioAssembler();

    private PrecioAssembler() {
        super();
    }

    public static Assembler<Precio, PrecioModel> getInstance() {
        return INSTANCE;
    }

    @Override
    public PrecioModel toModelFromDomain(Precio domain) {
        return PrecioModel.create()
                .setId(domain.getId())
                .setPrecio(domain.getPrecio())
                .setDivisa(DivisaAssembler.getInstance().toModelFromDomain(domain.getDivisa()));
    }

    @Override
    public Precio toDomainFromModel(PrecioModel model) {
        return Precio.create()
                .setId(model.getId())
                .setPrecio(model.getPrecio())
                .setDivisa(DivisaAssembler.getInstance().toDomainFromModel(model.getDivisa()));
    }

    @Override
    public List<Precio> toDomainListFromModel(List<PrecioModel> modelList) {
        return modelList.stream().map(entity -> toDomainFromModel(entity)).toList();
    }
}
