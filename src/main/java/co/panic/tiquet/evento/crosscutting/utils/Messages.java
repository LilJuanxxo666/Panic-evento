package co.panic.tiquet.evento.crosscutting.utils;

public final class Messages {

	private Messages() {
	}
	
	public static final class DivisaAPI {
		private DivisaAPI() {}
		
		public static final String ID_DIVISA_NOT_FOUND = "No se pudo encontrar la divisa con el ID proporcionado";
		public static final String DIVISA_UPDATE_OK= "Divisa actualizada exitosamente";
		public static final String DIVISA_DELETE_OK= "Divisa eliminada exitosamente";
	}
}
