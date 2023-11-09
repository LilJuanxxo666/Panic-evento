package co.panic.tiquet.evento.crosscutting.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class UtilDate {
	
	private static final String DEFAULT_DATE_AS_STRING = "0000-01-01";
	private static final LocalDate DEFAULT_DATE = LocalDate.parse(DEFAULT_DATE_AS_STRING, DateTimeFormatter.ISO_LOCAL_DATE);
	private static final String DATE_RE = "\\d{4}-\\d{2}-\\d{2}";
	
	private UtilDate() {
		super();
	}
	
	public static final LocalDate generateNowFecha() {
		return LocalDate.now();
	}
	
	public static final LocalDate getDefaultDate() {
		return DEFAULT_DATE;
	}
	
	public static final boolean dateStringIsValid(final String dateValue) {
		return (!UtilObject.isNull(dateValue) && dateValue.matches(DATE_RE));
	}
	
	public static final LocalDate generateFechaFromString(final String fechaValue) {
		return (dateStringIsValid(fechaValue)) ? LocalDate.parse(fechaValue, DateTimeFormatter.ISO_LOCAL_DATE) : DEFAULT_DATE;
	}
	
	public static final LocalDate getDefault(final LocalDate dateValue) {
		return (UtilObject.isNull(dateValue)) ? DEFAULT_DATE : dateValue;
	}
	
	public static final boolean isDefaultDateOrNull(final LocalDate dateValue) {
		return (UtilObject.isNull(dateValue) || dateValue.isEqual(DEFAULT_DATE));
	}
}