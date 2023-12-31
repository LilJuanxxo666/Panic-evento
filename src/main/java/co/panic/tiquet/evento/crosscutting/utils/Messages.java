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
	public static final class PrecioAPI{
		private PrecioAPI(){}
		public static final String ID_PRECIO_NOT_FOUND = "No se pudo encontrar el precio con el ID proporcionado";
		public static final String PRECIO_UPDATE_OK= "Precio actualizada exitosamente";
		public static final String PRECIO_DELETE_OK= "Precio eliminada exitosamente";
	}
	public static final class InformacionEventoAPI{
		private InformacionEventoAPI(){}
		public static final String ID_INFORMACION_EVENTO_NOT_FOUND = "No se pudo encontrar la informacion con el ID proporcionado";
		public static final String INFORMACION_EVENTO_UPDATE_OK= "Informacion evento actualizada exitosamente";
		public static final String INFORMACION_EVENTO_DELETE_OK= "Informacion eliminada exitosamente";
	}
	public static final class OfertaAPI{
		private OfertaAPI(){}
		public static final String ID_OFERTA_NOT_FOUND = "No se pudo encontrar la oferta con el ID proporcionado";
		public static final String OFERTA_UPDATE_OK= "Oferta actualizada exitosamente";
		public static final String OFERTA_DELETE_OK= "Oferta eliminada exitosamente";
	}
	public static final class EventoAPI{
		private EventoAPI(){}
		public static final String ID_EVENTO_NOT_FOUND = "No se pudo encontrar la evento con el ID proporcionado";
		public static final String EVENTO_UPDATE_OK= "Evento actualizada exitosamente";
		public static final String EVENTO_DELETE_OK= "Evento eliminada exitosamente";
	}
}
