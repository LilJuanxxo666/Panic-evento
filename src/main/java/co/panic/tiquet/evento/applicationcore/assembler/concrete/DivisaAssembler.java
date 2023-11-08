package co.panic.tiquet.evento.applicationcore.assembler.concrete;

import java.util.List;

import co.panic.tiquet.evento.applicationcore.assembler.Assembler;
import co.panic.tiquet.evento.applicationcore.domain.Divisa;
import co.panic.tiquet.evento.infraestructure.models.DivisaModel;

public class DivisaAssembler implements Assembler<Divisa, DivisaModel>{

	private static final Assembler<Divisa, DivisaModel> INSTANCE = new DivisaAssembler();
	
	private DivisaAssembler() {
		super();
	}
	
	public static Assembler<Divisa, DivisaModel> getInstance() {
		return INSTANCE;
	}
	
	@Override
	public DivisaModel toModelFromDomain(Divisa domain) {
		return DivisaModel.create().setId(domain.getId()).setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion());
	}
	
	@Override
	public Divisa toDomainFromModel(DivisaModel model) {
		return Divisa.create().setId(model.getId()).setNombre(model.getNombre())
				.setDescripcion(model.getDescripcion());
	}

	@Override
	public List<Divisa> toDomainListFromModel(List<DivisaModel> modelList) {
		return modelList.stream().map(entity -> toDomainFromModel(entity)).toList();
	}

}
