package co.panic.tiquet.evento.applicationcore.assembler.concrete;

import co.panic.tiquet.evento.applicationcore.assembler.Assembler;
import co.panic.tiquet.evento.applicationcore.domain.Oferta;
import co.panic.tiquet.evento.infraestructure.models.OfertaModel;

import java.util.List;

public class OfertaAssembler implements Assembler<Oferta, OfertaModel> {

    private static final Assembler<Oferta, OfertaModel> INSTANCE = new OfertaAssembler();

    private OfertaAssembler() {
        super();
    }

    public static Assembler<Oferta, OfertaModel> getInstance() {
        return INSTANCE;
    }

    @Override
    public OfertaModel toModelFromDomain(Oferta domain) {
        return OfertaModel.create()
                .setId(domain.getId())
                .setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion())
                .setPrecio(PrecioAssembler.getInstance().toModelFromDomain(domain.getPrecio()))
                .setArea(AreaAssembler.getInstance().toModelFromDomain(domain.getArea()));
    }

    @Override
    public Oferta toDomainFromModel(OfertaModel model) {
        return Oferta.create()
                .setId(model.getId())
                .setNombre(model.getNombre())
                .setDescripcion(model.getDescripcion())
                .setPrecio(PrecioAssembler.getInstance().toDomainFromModel(model.getPrecio()))
                .setArea(AreaAssembler.getInstance().toDomainFromModel(model.getArea()));
    }

    @Override
    public List<Oferta> toDomainListFromModel(List<OfertaModel> modelList) {
        return modelList.stream().map(entity -> toDomainFromModel(entity)).toList();
    }
}
