package br.com.healthtrack.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static Date asDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static java.sql.Date asSqlDate(LocalDateTime localDateTime) {
		return java.sql.Date.valueOf(localDateTime.toLocalDate());
	}
	
	public static java.sql.Date asSqlDate(LocalDate localDate) {
		return java.sql.Date.valueOf(localDate);
	}
	
	public static java.sql.Timestamp asSqlTimestamp(LocalDateTime localDateTime) {
		return Timestamp.valueOf(localDateTime);
	}
	
	public static LocalDateTime asLocalDateTime(java.sql.Timestamp timestamp) {
		return timestamp.toLocalDateTime();
	}
	
	public static LocalDate asLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static LocalDateTime asLocalDateTime(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	
	public static LocalDateTime asLocalDateTime(java.sql.Date date) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
	}
}
