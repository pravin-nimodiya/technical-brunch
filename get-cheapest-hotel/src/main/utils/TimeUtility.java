package main.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import main.exception.InputException;

public class TimeUtility {

	private static final String DATE_FORMAT = "dd-mm-yyyy";
	public static SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);

	public static Date getUtcTime(String inputDateTime) throws InputException {

		TimeZone inputTz = TimeZone.getTimeZone("Asia/Jarkarta");
		TimeZone utcTz = TimeZone.getTimeZone("UTC");

		SimpleDateFormat inputSdf = new SimpleDateFormat(DATE_FORMAT);
		inputSdf.setTimeZone(inputTz);

		SimpleDateFormat utcSdf = new SimpleDateFormat(DATE_FORMAT);
		utcSdf.setTimeZone(utcTz);

		// From time
		Date fromDate = null;
		try {
			fromDate = inputSdf.parse(inputDateTime);
			return fromDate;
		} catch (ParseException e) {
			throw new InputException(InputException.INVALID_DATE_INPUT);
		}
	}

}
