package com.zmt.dateservice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateService {
	
	// we accept only the ISO-8601 date format
		public static boolean isValid(String date) {
			try {
				DateTimeFormatter.ISO_INSTANT.parse(date);
				return true;
			} catch (DateTimeParseException e) {
				return false;
			}
		}

		public static Date toDate(String timeString) {
			DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
			Date date = null;
			try {
				date = dateFormat.parse(timeString);
			} catch (ParseException e) {
				throw new RuntimeException("Error while parsing timestamp", e) ;
			}
			return date;
		}
		
		// the result is returned in milliseconds 
		public static long getDifferenceInTimes(Date d1, Date d2) {
			long diff = d2.getTime() - d1.getTime();
			return diff;
		}

		// calculate the difference between timestamps, in a given format
		public static String calculate(Date d1, Date d2) {
			String result = "";
			long diffInTime = getDifferenceInTimes(d1, d2);
			long diffInSeconds = (diffInTime / 1000) % 60;
			long diffInMinuts = (diffInTime / (1000 * 60)) % 60;
			long diffInHours = (diffInTime / (1000 * 60 * 60)) % 24;
			long diffInDays = (diffInTime / (1000 * 60 * 60 * 24)) ;
			
			String daysDisplay = (diffInDays > 0) ? diffInDays + " day" + Constants.OUTPUT_RECORD_SEPARATOR : "";
			String hoursDisplay = (diffInHours > 0 || diffInDays > 0) ? diffInHours + " hours" + Constants.OUTPUT_RECORD_SEPARATOR : "";
			String minuteDisplay = (diffInMinuts > 0 || diffInHours> 0) ? diffInMinuts + " minutes" + Constants.OUTPUT_RECORD_SEPARATOR : "";
			String secondeDisplay = (diffInSeconds > 0) ? diffInSeconds + " second" : "";
			
			if( !(diffInTime <= 0) ) {
				result = daysDisplay + hoursDisplay + minuteDisplay + secondeDisplay;
			}
			return result;
		}
		
		public static String printVectauryFormat(String[] record) {
			return calculate(toDate(record[0]),toDate(record[1]));
		}
}
