package com.cda.tools;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");	//initialisation datetimeformatter
		
	public static String formaterPrixOuPois(float pPrixOuPoids) {
		return DECIMAL_FORMAT.format(pPrixOuPoids);
	}
	
	public static String formaterDate(LocalDateTime pDate) {	//formattage de la date pour affichage propre
		 return pDate.format(DATE_FORMAT);
	}
}
