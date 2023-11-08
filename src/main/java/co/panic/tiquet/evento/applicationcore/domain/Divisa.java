package co.panic.tiquet.evento.applicationcore.domain;

import java.util.UUID;

import co.panic.tiquet.evento.crosscutting.utils.UtilText;
import co.panic.tiquet.evento.crosscutting.utils.UtilUUID;

public class Divisa {
	private UUID id;
	private String nombre;
	private String descripcion;
	
	private Divisa() {
		setId(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getUtilText().getDefaultValue());
		setDescripcion(UtilText.getUtilText().getDefaultValue());
	}

	public Divisa(UUID id, String nombre, String descripcion) {
		setId(id);
		setNombre(nombre);
		setDescripcion(descripcion);
	}
	
	public static Divisa create() {
		return new Divisa();
	}

	public UUID getId() {
		return id;
	}

	public Divisa setId(final UUID identificador) {
		this.id = UtilUUID.getDefault(identificador);
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public Divisa setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Divisa setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}
}
