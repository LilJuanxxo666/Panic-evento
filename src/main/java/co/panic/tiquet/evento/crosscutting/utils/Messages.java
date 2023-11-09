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
	public static final class AreaAPI{
		private AreaAPI(){}
		public static final String ID_AREA_NOT_FOUND = "No se pudo encontrar la area con el ID proporcionado";
		public static final String AREA_UPDATE_OK= "Area actualizada exitosamente";
		public static final String AREA_DELETE_OK= "Area eliminada exitosamente";
	}
}
