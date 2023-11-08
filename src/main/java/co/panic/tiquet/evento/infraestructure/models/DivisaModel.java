package co.panic.tiquet.evento.infraestructure.models;

import java.util.UUID;

import co.panic.tiquet.evento.crosscutting.utils.UtilText;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Divisa")
public class DivisaModel {

	@Id
	private UUID id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	private DivisaModel() {
		setId(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getUtilText().getDefaultValue());
		setDescripcion(UtilText.getUtilText().getDefaultValue());
	}

	public DivisaModel(UUID id, String nombre, String descripcion) {
		setId(id);
		setNombre(nombre);
		setDescripcion(descripcion);
	}
	
	public static DivisaModel create() {
		return new DivisaModel();
	}

	public UUID getId() {
		return id;
	}

	public DivisaModel setId(UUID id) {
		this.id = UtilUUID.getDefault(id);
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public DivisaModel setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public DivisaModel setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}
}
