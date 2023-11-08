package co.panic.tiquet.evento.applicationcore.assembler;

import java.util.List;

public interface Assembler <D, M>{

	M toModelFromDomain(D domain);
	
	D toDomainFromModel(M model);
	
	List<D> toDomainListFromModel (List<M> modelList);
}
